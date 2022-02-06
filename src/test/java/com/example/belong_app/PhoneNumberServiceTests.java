package com.example.belong_app;

import com.example.belong_app.dao.PhoneNumberRepository;
import com.example.belong_app.dao.UserRepository;
import com.example.belong_app.service.PhoneNumberService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class PhoneNumberServiceTests {

    @Autowired
    private PhoneNumberService service;
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testActivateInvalidPhoneNumber() throws ParseException {

        HashMap<String, String> result = service.activate("9865989", null);
        Assert.assertEquals(result.get("error"), "true");
        Assert.assertEquals(result.get("msg"), "Invalid number");
    }

    @Test
    public void testActivateActivatedPhoneNumber() throws ParseException {

        HashMap<String, String> result = service.activate("5469584", null);
        Assert.assertEquals(result.get("error"), "true");
        Assert.assertEquals(result.get("msg"), "Already an active number");
    }

    @Test
    public void testActivateUnassignedPhoneNumber() throws ParseException {

        HashMap<String, String> result = service.activate("23345456", null);
        Assert.assertEquals(result.get("error"), "true");
        Assert.assertEquals(result.get("msg"), "Cannot activate number without a user");
    }

    @Test
    public void testActivatePhoneNumberWithInvalidUser() throws ParseException {

        HashMap<String, String> result = service.activate("23345456", "6");
        Assert.assertEquals(result.get("error"), "true");
        Assert.assertEquals(result.get("msg"), "Invalid customer id");
    }

    @Test
    public void testActivateUserDeactivatedPhoneNumber() throws ParseException {

        HashMap<String, String> result = service.activate("23784589", null);
        Assert.assertEquals(result.get("error"), "false");
        Assert.assertEquals(result.get("msg"), "Number activated");
    }

}
