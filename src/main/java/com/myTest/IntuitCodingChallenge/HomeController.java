package com.myTest.IntuitCodingChallenge;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Value("${app.version}")
    private String bversion;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> ping() {
        StringBuilder responseString = new StringBuilder();
        responseString.append("Voting Service is up !!! ");
        responseString.append("\n Running Version : ");
        responseString.append(bversion);
        return new ResponseEntity<String>(responseString.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/store", method = RequestMethod.PUT)
    public void storeThumpsup(String category, boolean thumbsup) {
        System.out.println("category : " + category + "; thumbsup : " + thumbsup);
    }
}