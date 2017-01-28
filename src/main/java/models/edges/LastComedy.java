package models.edges;

import models.nodes.Comedy;
import models.nodes.ComedyActor;
import models.nodes.Drama;
import models.nodes.StageActor;
import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type="LAST_APPEARENCE")
public class LastComedy extends BaseEdge<ComedyActor, Comedy>{

    public LastComedy() {
        super();
    }

    public LastComedy(ComedyActor start, Comedy end, String title) {
        super(start, end, title);
    }
}
