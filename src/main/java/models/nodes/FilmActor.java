package models.nodes;


import models.edges.LastMovie;
import models.edges.PlayedInMovie;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class FilmActor extends BaseNode {
    public FilmActor(){
        super();
    }
    public FilmActor(String title){
        super(title);
    }

    @Relationship(type="PLAYED_IN", direction = Relationship.OUTGOING)
    public Set<PlayedInMovie> movies = new HashSet<PlayedInMovie>();

    @Relationship(type = "LAST_APPEARENCE", direction = Relationship.OUTGOING)
    public LastMovie lastMovie;


}
