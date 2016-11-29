package models.nodes;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Child extends BaseNode {

    public Child(){
        super();
    }
    public Child(String title){
        super(title);
    }
}
