package com.myTest.IntuitCodingChallenge;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.myTest.common.MovieDetails;
import com.myTest.service.CacheService;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Created by NUS889 on 12/17/2017.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = HomeController.class, secure = false)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CacheService service;

//    MovieDetails mockdetails = new MovieDetails(2, "Troy", "thumbsUp");

    HomeController controller = EasyMock.createNiceMock(HomeController.class);


    @Test
    public void testController(){

//        Mockito.when(service.putMovieDetails();)
    }

    @Test
    @Ignore
    public void testPing() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ping");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.print(result.getResponse());
        Assert.assertEquals("voting system is up", result.getResponse());
    }


}
