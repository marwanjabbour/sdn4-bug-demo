package models.nodes;

import models.edges.LastDrama;
import models.edges.PlayedInDrama;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class StageActor extends BaseNode {
    public StageActor() { super(); }
    public StageActor(String title) { super(title); }

    @Relationship(type="PLAYED_IN", direction = Relationship.OUTGOING)
    public Set<PlayedInDrama> dramas = new HashSet<PlayedInDrama>();

    @Relationship(type = "LAST_APPEARENCE", direction = Relationship.OUTGOING)
    public LastDrama lastDrama;

}
