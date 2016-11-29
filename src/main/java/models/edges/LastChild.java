package models.edges;

import models.nodes.BaseNode;
import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type="LAST_CHILD")
public class LastChild extends BaseEdge<BaseNode> {

    public LastChild() {
        super();
    }

    public LastChild(BaseNode start, BaseNode end, String title) {
        super(start, end, title);
    }

}
