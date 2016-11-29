package models.nodes;

import models.edges.HasChild;
import models.edges.LastChild;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Parent extends BaseNode {

  @Relationship(type="HAS_CHILD", direction = Relationship.OUTGOING)
  public Set<HasChild> children = new HashSet<HasChild>();

  @Relationship(type = "LAST_CHILD", direction = Relationship.OUTGOING)
  public LastChild lastChild;

  public Parent(){
    super();
  }

  public Parent(String title){
    super(title);
  }
}
