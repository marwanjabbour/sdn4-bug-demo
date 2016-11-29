package models.edges;

import models.nodes.BaseNode;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.StartNode;

public abstract class BaseEdge<T extends BaseNode> {

    @GraphId
    public Long relationshipId;

    @Property
    public String title;

    @StartNode
    public T start;

    @EndNode
    public T end;

    public BaseEdge() {
        super();
    }

    public BaseEdge(T start, T end, String title) {
        this.start = start;
        this.end = end;
        this.title = title;
    }
}