package com.myTest.service;

import com.myTest.common.MovieDetails;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NUS889 on 12/16/2017.
 */
@Service
public class CacheService {

    private static final Logger logger = LogManager.getLogger(CacheService.class);

    private static Map<String, MovieDetails> movieDetailsHashMap = new HashMap<String, MovieDetails>();

    @CachePut(value="movieDetails", key="#movieStatus")
    public void putMovieDetails(String movieStatus, MovieDetails movieDetails){
        logger.info("Class: "+ logger.getClass().getName() +", Method: putMovieDetails(), Stage: Started" );
        MovieDetails details = movieDetailsHashMap.get(movieStatus);
        details.setMovieName(movieDetails.getMovieName());
        details.setStatus(movieDetails.getStatus());
        details.setValue(movieDetails.getValue());
        movieDetailsHashMap.put(movieStatus, details);
        logger.info("Class: "+ logger.getClass().getName() +", Method: putMovieDetails(), Stage: Ended" );
    }

    @CacheEvict(value = "MovieDetails", key = "#movieStatus")
    public void removeMovieDetails(String movieStatus){
        logger.info("Class: "+ logger.getClass().getName() +", Method: removeMovieDetails(), Stage: Started" );
        logger.info("Removing the map >>> "+movieStatus);
        movieDetailsHashMap.remove(movieStatus);
        logger.info("Class: "+ logger.getClass().getName() +", Method: removeMovieDetails(), Stage: Ended" );
    }

    @CacheEvict
    public void resetMovieDetails(){
        logger.info("Class: "+ logger.getClass().getName() +", Method: resetMovieDetails(), Stage: Started" );
        logger.info("Clearing the map !!! ");
        movieDetailsHashMap.clear();
        logger.info("Class: "+ logger.getClass().getName() +", Method: resetMovieDetails(), Stage: Ended" );
    }
}
