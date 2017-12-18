package com.myTest.IntuitCodingChallenge;


import com.myTest.common.MovieDetails;
import com.myTest.service.CacheService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class HomeController {

    @Value("${app.version}")
    private String appVersion;

    @Autowired
    private CacheService cacheService;

    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> ping() {
        logger.info("Class: "+ logger.getClass().getName() +", Method: ping(), Stage: Started" );

        StringBuilder responseString = new StringBuilder();
        responseString.append("Voting Service is up !!! ");
        responseString.append("... Running Version : ");
        responseString.append(appVersion);

        logger.info("Class: "+ logger.getClass().getName() +", Method: ping(), Stage: Ended" );
        return new ResponseEntity<String>(responseString.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/storeMovieDetails", method = RequestMethod.POST)
    public ResponseEntity<Void> storeThumpsup(@RequestBody MovieDetails movieDetails, UriComponentsBuilder ucBuilder) {
        logger.info("Class: "+ this.getClass().getSimpleName() +", Method: updateMovieDetails(), Stage: Started" );

        Assert.isNull(movieDetails, "No Movie Details !!!");
        MovieDetails details = new MovieDetails();

        details.setMovieName(movieDetails.getMovieName());
        details.setStatus(movieDetails.getStatus());
        details.setValue(movieDetails.getValue());
        String key = movieDetails.getMovieName().concat("_").concat(movieDetails.getStatus());

        cacheService.putMovieDetails(key, details);
        logger.info("Class: "+ logger.getClass().getName() +", Method: updateMovieDetails(), Stage: Ended" );

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/storeMovieDetails/{key}").buildAndExpand(key).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(value = "/updateMovieDetails/{movieName}/{status}/{value}", method = RequestMethod.POST)
    public String addMovieDetails(@PathVariable(value = "movieName") String movieName,
                                  @PathVariable(value = "status") String status,
                                  @PathVariable(value = "value") int value) {
        logger.info("Class: "+ logger.getClass().getName() +", Method: updateMovieDetails(), Stage: Started" );
        MovieDetails details = new MovieDetails();

        String key = movieName.concat("_").concat(status);
        details.setMovieName(movieName);
        details.setStatus(status);
        details.setValue(value);

        cacheService.putMovieDetails(key, details);
        logger.info("Class: "+ logger.getClass().getName() +", Method: updateMovieDetails(), Stage: Ended" );
        return ("movieName : " + movieName + "; Status : " + status + "; Value : " + value);
    }

    @ResponseBody
    @RequestMapping(value = "/updateMovieDetails/{movieName}/{status}/{value}", method = RequestMethod.PUT)
    public String updateMovieDetails(@PathVariable(value = "movieName") String movieName,
                                     @PathVariable(value = "status") String status,
                                     @PathVariable(value = "value") int value) {
        logger.info("Class: "+ logger.getClass().getName() +", Method: updateMovieDetails(), Stage: Started" );
        MovieDetails details = new MovieDetails();

        String key = movieName.concat("_").concat(status);
        details.setMovieName(movieName);
        details.setStatus(status);
        details.setValue(value);

        cacheService.putMovieDetails(key, details);
        logger.info("Class: "+ logger.getClass().getName() +", Method: updateMovieDetails(), Stage: Ended" );
        return ("movieName : " + movieName + "; Status : " + status + "; Value : " + value);
    }

    @RequestMapping(value = "/resetValues", method = RequestMethod.DELETE)
    public @ResponseBody String resetValues() {
        cacheService.resetMovieDetails();
        return "Cleared all values !!!";
    }

}