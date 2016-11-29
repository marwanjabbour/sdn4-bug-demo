
import models.edges.HasChild;
import models.edges.LastChild;
import models.nodes.Child;
import models.nodes.Parent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void shouldRetrieveAllAndLastChildren() {


        Parent parent0 = new Parent("Parent 0");
        Child child01 = new Child("Child 01");
        Child child02 = new Child("Child 02");

        parent0.children.add(new HasChild(parent0, child01, "rel 1"));
        parent0.children.add(new HasChild(parent0, child02, "rel 2"));
        parent0.lastChild = new LastChild(parent0, child02, "rel 3");

        neo4jTemplate.save(parent0);

        neo4jTemplate.clear();

        Parent p2 = neo4jTemplate.load(Parent.class, parent0.id);
        Assert.assertEquals(p2.children.size(), 3);
        Assert.assertNotNull(p2.lastChild);
    }

}
