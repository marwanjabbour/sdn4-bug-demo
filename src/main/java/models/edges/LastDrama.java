package models.edges;

import models.nodes.Drama;
import models.nodes.StageActor;
import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type="LAST_APPEARENCE")
public class LastDrama extends BaseEdge<StageActor, Drama>{

    public LastDrama() {
        super();
    }

    public LastDrama(StageActor start, Drama end, String title) {
        super(start, end, title);
    }
}
