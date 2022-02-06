package com.example.belong_app.controller;

import com.example.belong_app.dao.PhoneNumberRepository;
import com.example.belong_app.model.PhoneNumber;
import com.example.belong_app.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

/***
 * Phone number controller
 */
@Controller
public class PhoneNumberController {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;
    @Autowired
    private PhoneNumberService phoneNumberService;

    /***
     * This is used to add a phone number to the system
     * @param number
     * @param status
     * @param startDate
     * @param userId
     * @return
     */
    @PostMapping("/addPhoneNumber")
    public String addPhoneNumber(@RequestParam String number, @RequestParam String status, @RequestParam Date startDate, @RequestParam Integer userId) {
        PhoneNumber phoneNumber = new PhoneNumber(number,status,startDate, userId);
        phoneNumberRepository.save(phoneNumber);
        return "Added new PhoneNumber";
    }

    /***
     * This is used to list all the phone numbers of the system
     * @return
     */
    @GetMapping("/listPhoneNumbers")
    public ModelAndView getPhoneNumbers() {

        ModelAndView model = new ModelAndView("phoneNumber/list");
        model.addObject("phoneNumberList", phoneNumberRepository.findAll());
        return model;
    }

    /***
     * This is used to find a phone number by its number
     * @param number
     * @return
     */
    @GetMapping("/findPhoneNumber/{number}")
    public PhoneNumber findPhoneNumberByNumber(@PathVariable String number) {
        return phoneNumberRepository.findPhoneNumberByNumber(number);
    }

    /***
     * This is used to activate a phone number
     * @param body
     * @return
     * @throws ParseException
     */
    @PostMapping("/activate")
    public ModelAndView activate(@RequestBody String body) throws ParseException {

        String[] list = body.split("&");
        HashMap<String, String> items = new HashMap<>();

        for (String item : list)
        {
            String[] att = item.split("=");
            items.put(att[0], att.length == 1 ? null: att[1]);
        }

        HashMap<String, String> result = phoneNumberService.activate(items.get("number"),items.get("customerId"));
        ModelAndView model = new ModelAndView("phoneNumber/index");
        model.addObject("result", result);
        model.addObject("numberDetails", phoneNumberRepository.findPhoneNumberByNumber(items.get("number")));
        return model;
    }

    /***
     * This is used to deactivate a phone number
     * @param numberString
     * @return
     */
    @PostMapping("/deactivate")
    public String deactivate(@RequestBody String numberString) {
        String number = numberString.split("=")[1];
        return phoneNumberService.deactivate(number).get("msg");
    }

}
