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
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Value("${app.version}")
    private String appVersion;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private MovieDetails details;

    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public @ResponseBody String ping() {
        return "voting system is up";
    }

    @RequestMapping(value = "/pings", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> pings() {
        logger.info("Class: "+ logger.getClass().getName() +", Method: ping(), Stage: Started" );

        StringBuilder responseString = new StringBuilder();
        responseString.append("Voting Service is up !!! ");
        responseString.append("\n");
        responseString.append("Running Version : ");
        responseString.append(appVersion);

        logger.info("Class: "+ logger.getClass().getName() +", Method: ping(), Stage: Ended" );
        return new ResponseEntity<String>(responseString.toString(), HttpStatus.OK);
    }

    /*@RequestMapping(value = "/store", method = RequestMethod.PUT)
    public void storeThumpsup(String category, boolean thumbsup) {
        System.out.println("category : " + category + "; thumbsup : " + thumbsup);
    }*/

    @ResponseBody
    @RequestMapping(value = "/update/{movieName}/{status}/{value}", method = RequestMethod.PUT)
    public String update(@PathVariable(value = "movieName") String movieName,
                         @PathVariable(value = "status") String status,
                         @PathVariable(value = "value") int value) {
        logger.info("Class: "+ logger.getClass().getName() +", Method: update(), Stage: Started" );
        String key = movieName.concat("_").concat(status);
        details.setMovieName(movieName);
        details.setStatus(status);
        details.setValue(value);

        cacheService.putMovieDetails(key, details);
        logger.info("Class: "+ logger.getClass().getName() +", Method: update(), Stage: Ended" );
        return ("movieName : " + movieName + "; Status : " + status + "; Value : " + value);
    }

    /*@RequestMapping(method=RequestMethod.PUT, value="/update/{category}/{status}/{value}")
    public String update(@PathParam("category") String category, @PathParam("status") String status, @PathParam("value") String value) {
        if (status.equalsIgnoreCase("thumbsup")){
            System.out.println("category : " + category + "; Status : " + status + "; Value : " + value);
        } else {
            System.out.println("category : " + category + "; Status : " + status + "; Value : " + value);
        }
        return ("category : " + category + "; Status : " + status + "; Value : " + value);
    }*/

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public @ResponseBody String error() {
        return "error.html";
    }

    @RequestMapping(value = "/resetValues", method = RequestMethod.DELETE)
    public @ResponseBody String resetValues() {
        cacheService.resetMovieDetails();
        return "Cleared all values !!!";
    }

}