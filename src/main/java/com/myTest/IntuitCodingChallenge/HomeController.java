package com.myTest.IntuitCodingChallenge;


import com.myTest.common.MovieDetails;
import com.myTest.service.CacheService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/*
* Controller class where all the Rest api are exposed
*
* Created by NUS889 on 12/16/2017.
* */
@Controller
public class HomeController {

    @Value("${app.version}")
    private String appVersion;

    @Autowired
    private CacheService cacheService;

    private static final Logger logger = LogManager.getLogger(HomeController.class);

    /*
    *  Generic Health check method for Application
    * */
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<String> ping() {
        logger.info("Class: " + logger.getClass().getName() + ", Method: ping(), Stage: Started");

        StringBuilder responseString = new StringBuilder();
        responseString.append("Voting Service is up !!! ");
        responseString.append("... Running Version : ");
        responseString.append(appVersion);

        logger.info("Class: " + logger.getClass().getName() + ", Method: ping(), Stage: Ended");
        return new ResponseEntity<String>(responseString.toString(), HttpStatus.OK);
    }

    /*
    * Rest API to store the counter values
    * */
    @RequestMapping(value = "/storeMovieDetails", method = RequestMethod.PUT)
    public ResponseEntity<Integer> storeMovieDetails(@RequestBody MovieDetails movieDetails) {
        logger.info("Method: updateMovieDetails(), Stage: Started");
        Assert.notNull(movieDetails, "No Movie Details !!!");
        String key = movieDetails.getMovieName().concat("_").concat(movieDetails.getType());

        if (cacheService.checkIfKeyExists(key)){
            cacheService.putMovieDetails(key, increment(cacheService.getMovieDetails(key)));
        }else {
            cacheService.putMovieDetails(key, increment(0));
        }
        logger.info("Updated Value : " + cacheService.getMovieDetails(key).intValue() + ", Method: updateMovieDetails(), Stage: Ended");
        return new ResponseEntity<Integer>(cacheService.getMovieDetails(key), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/resetValues", method = RequestMethod.DELETE)
    public
    @ResponseBody
    String resetValues() {
        logger.info("Method: resetValues(), Stage: Started");
        cacheService.resetMovieDetails();
        logger.info("Method: resetValues(), Stage: Ended");
        return "Cleared all values !!!";
    }

    private int increment(int count) {
        return ++count;
    }

}