import models.edges.LastComedy;
import models.edges.LastDrama;
import models.edges.PlayedInComedy;
import models.edges.PlayedInDrama;
import models.nodes.Comedy;
import models.nodes.ComedyActor;
import models.nodes.Drama;
import models.nodes.StageActor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
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

    @Autowired
    private Session session;

    @Test
    public void shouldReloadEntitiesJustSaved() {
        StageActor stageActor = new StageActor("first actor");
        Drama firstDrama = new Drama("malade imaginaire");
        Drama secondDrama = new Drama("Le cid");

        ComedyActor comedyActor = new ComedyActor("second actor");
        Comedy firstComedy = new Comedy("Bourgeois gentilhomme");

        stageActor.dramas.add(new PlayedInDrama(stageActor, firstDrama, "rel1"));
        stageActor.dramas.add(new PlayedInDrama(stageActor, secondDrama, "rel2"));
        stageActor.lastDrama = new LastDrama(stageActor, secondDrama, "last");

        comedyActor.comedies.add(new PlayedInComedy(comedyActor, firstComedy, "rel3"));
        comedyActor.lastComedy = new LastComedy(comedyActor, firstComedy, "last2");

        System.out.println("SAVING ***********");
        neo4jTemplate.save(stageActor);
        neo4jTemplate.save(comedyActor);
        System.out.println("SAVED ***********");

        neo4jTemplate.clear();
        System.out.println("CLEARED **********");

        StageActor reloadedActor = session.load(StageActor.class, stageActor.id);

        Assert.assertEquals(2, reloadedActor.dramas.size());
        Assert.assertNotNull(reloadedActor.lastDrama);
    }

}
