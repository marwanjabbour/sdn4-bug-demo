package models.edges;

import models.nodes.FilmActor;
import models.nodes.Movie;
import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type="PLAYED_IN")
public class PlayedInMovie extends BaseEdge<FilmActor, Movie>{

    public PlayedInMovie() {
        super();
    }

    public PlayedInMovie(FilmActor start, Movie end, String title) {
        super(start, end, title);
    }

}
