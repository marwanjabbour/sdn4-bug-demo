package models.nodes;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Comedy extends BaseNode {

    public Comedy() {
        super();
    }

    public Comedy(String title) {
        super(title);
    }
}
