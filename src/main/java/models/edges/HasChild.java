package models.edges;

import models.nodes.BaseNode;
import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type="HAS_CHILD")
public class HasChild extends BaseEdge<BaseNode> {

    public HasChild() {
        super();
    }

    public HasChild(BaseNode start, BaseNode end, String title) {
        super(start, end, title);
    }
}
