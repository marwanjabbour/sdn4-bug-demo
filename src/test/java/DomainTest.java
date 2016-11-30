import models.edges.LastDrama;
import models.edges.PlayedInDrama;
import models.nodes.Drama;
import models.nodes.StageActor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceContext.class})
@Transactional
public class DomainTest {

    @Autowired
    private Neo4jOperations neo4jTemplate;

    @Test
    public void shouldReloadEntitiesJustSaved() {
        StageActor stageActor = new StageActor("first actor");
        Drama firstDrama = new Drama("malade imaginaire");
        Drama secondDrama = new Drama("Le cid");

        stageActor.dramas.add(new PlayedInDrama(stageActor, firstDrama, "rel1"));
        stageActor.dramas.add(new PlayedInDrama(stageActor, secondDrama, "rel2"));
        stageActor.lastDrama = new LastDrama(stageActor, secondDrama, "last");

        neo4jTemplate.save(stageActor);

        neo4jTemplate.clear();

        StageActor reloadedActor = neo4jTemplate.load(StageActor.class, stageActor.id);

        Assert.assertEquals(2, reloadedActor.dramas.size());
        Assert.assertNotNull(reloadedActor.lastDrama);
    }

}
