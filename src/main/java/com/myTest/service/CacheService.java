package com.myTest.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * This class has all the caching mechanism for this application
 *
 * Created by NUS889 on 12/16/2017.
 */
@Service
public class CacheService {

    private static final Logger logger = LogManager.getLogger(CacheService.class);

    private static Map<String, Integer> movieDetailsHashMap = new HashMap<String, Integer>();

    /*
    * This method fetches the HAshMap value for the Key
    * */
    public Integer getMovieDetails(String movieKeyID){
        logger.info("Method: getMovieDetails(), Stage: Started" );
        return movieDetailsHashMap.get(movieKeyID);
    }

    /*
    * This method is used to store the counter values using Cache to HashMap
    * */
    @CachePut(value="counterValue", key="#movieKeyID")
    public Map<String, Integer> putMovieDetails(String movieKeyID, int counterValue){
        logger.info("Method: putMovieDetails(), Stage: Started" );
        movieDetailsHashMap.put(movieKeyID, counterValue);
        logger.info("Method: putMovieDetails(), Stage: Ended" );
        return movieDetailsHashMap;
    }

    /*
    * This Method resets the Cached HashMap
    * */
    @CacheEvict(value = "counterValue", allEntries = true)
    public void resetMovieDetails(){
        logger.info("Method: resetMovieDetails(), Stage: Started" );
        logger.info("Clearing the map !!! ");
        movieDetailsHashMap.clear();
        logger.info("Method: resetMovieDetails(), Stage: Ended" );
    }

    /*
    * This method is used to check is the Key exists
    * */
    public boolean checkIfKeyExists(String key){
        logger.info("Method: checkIfKeyExists(), Stage: Started" );
        if (movieDetailsHashMap.containsKey(key)){
            return true;
        } else {
            return false;
        }
    }
}
