package com.myTest.IntuitCodingChallenge;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myTest.common.MovieDetails;
import com.myTest.service.CacheService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/*
* Controller class where all the Rest api are exposed
*
* Created by NUS889 on 12/16/2017.
* */
@Controller
@Api(value="Voting Arena", description="Operations pertaining to movie voting !!!")
public class HomeController {

    @Value("${app.version}")
    private String appVersion;

    @Autowired
    private CacheService cacheService;

    private static final Logger logger = LogManager.getLogger(HomeController.class);

    /*
    *  Generic Health check method for Application
    * */
    @ApiOperation(value = "Application Health Check")
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> ping() {
        logger.info("Method: ping(), Stage: Started");

        StringBuilder responseString = new StringBuilder();
        responseString.append("Voting Service is up !!! ");
        responseString.append("... Running Version : ");
        responseString.append(appVersion);

        logger.info("Method: ping(), Stage: Ended");
        return new ResponseEntity<String>(responseString.toString(), HttpStatus.OK);
    }

    /*
    * Rest API to store the counter values
    * */
    @ApiOperation( 
    	    value = "Store Movie Details", 
    	    notes = "Store Movie Review Details (likes/ dislikes) ", 	
    	    response = ResponseEntity.class 
    	)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Stored Movie details"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/storeMovieDetails", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
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

    @ApiOperation(value = "Clear Saved Movie Details")
    @RequestMapping(value = "/resetValues", method = RequestMethod.DELETE)
    @ResponseBody
    public String resetValues() {
        logger.info("Method: resetValues(), Stage: Started");
        cacheService.resetMovieDetails();
        logger.info("Method: resetValues(), Stage: Ended");
        return "Cleared all values !!!";
    }

    private int increment(int count) {
        return ++count;
    }

}
