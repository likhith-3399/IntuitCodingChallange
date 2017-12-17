package com.myTest.common;

import org.springframework.stereotype.Component;

/**
 * Created by NUS889 on 12/16/2017.
 */
@Component
public class MovieDetails {

    private int value;
    private String movieName;
    private String status;

    public MovieDetails(int value, String movieName, String status){
        this.value = value;
        this.movieName = movieName;
        this.status = status;
    }

    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
