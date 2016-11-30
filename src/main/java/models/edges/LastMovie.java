package models.edges;

import models.nodes.FilmActor;
import models.nodes.Movie;
import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type="LAST_APPEARENCE")
public class LastMovie extends BaseEdge<FilmActor, Movie>{

    public LastMovie() {
        super();
    }

    public LastMovie(FilmActor start, Movie end, String title) {
        super(start, end, title);
    }
}
