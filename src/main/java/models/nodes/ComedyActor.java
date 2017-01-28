package models.nodes;

import models.edges.LastComedy;
import models.edges.LastMovie;
import models.edges.PlayedInComedy;
import models.edges.PlayedInMovie;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class ComedyActor extends BaseNode {
    public ComedyActor(){
        super();
    }
    public ComedyActor(String title){
        super(title);
    }

    @Relationship(type="PLAYED_IN", direction = Relationship.OUTGOING)
    public Set<PlayedInComedy> comedies = new HashSet<PlayedInComedy>();

    @Relationship(type = "LAST_APPEARENCE", direction = Relationship.OUTGOING)
    public LastComedy lastComedy;

}