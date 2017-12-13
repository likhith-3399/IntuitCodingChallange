package com.myTest.IntuitCodingChallenge;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping(value = "/ping")
    @ResponseBody
    public String ping() {
        return "voting system is up";
    }
    @RequestMapping(value = "/store", method = RequestMethod.PUT)
   public void storeThumpsup(String category, boolean thumbsup) {
        System.out.println("category : " + category + "; thumbsup : " + thumbsup);
    }
}