package models.edges;

import models.nodes.Drama;
import models.nodes.StageActor;
import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type="PLAYED_IN")
public class PlayedInDrama extends BaseEdge<StageActor, Drama>{

    public PlayedInDrama() {
        super();
    }

    public PlayedInDrama(StageActor start, Drama end, String title) {
        super(start, end, title);
    }

}
