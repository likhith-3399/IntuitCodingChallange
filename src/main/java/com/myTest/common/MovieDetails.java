package com.myTest.common;

import java.io.Serializable;

/**
 * POJO class for Movie
 *
 * Created by NUS889 on 12/16/2017.
 */
public class MovieDetails implements Serializable {

    private String movieName;
    private String type;

    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
