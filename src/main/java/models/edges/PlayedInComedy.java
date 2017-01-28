package models.edges;

import models.nodes.Comedy;
import models.nodes.ComedyActor;
import models.nodes.Drama;
import models.nodes.StageActor;
import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type="PLAYED_IN")
public class PlayedInComedy extends BaseEdge<ComedyActor, Comedy>{

    public PlayedInComedy() {
        super();
    }

    public PlayedInComedy(ComedyActor start, Comedy end, String title) {
        super(start, end, title);
    }

}
