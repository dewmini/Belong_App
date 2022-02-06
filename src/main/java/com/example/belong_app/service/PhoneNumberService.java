package com.example.belong_app.service;

import com.example.belong_app.dao.PhoneNumberRepository;
import com.example.belong_app.dao.UserRepository;
import com.example.belong_app.model.PhoneNumber;
import com.example.belong_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/***
 * This is the phone number service class. This provides special services for phone number entity.
 */
@Service
public class PhoneNumberService {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;
    @Autowired
    private UserRepository userRepository;

    /***
     * This method is used to activate a phone number.
     * @param number
     * @param customerId
     * @return
     * @throws ParseException
     */
    public HashMap<String, String> activate(String number, String customerId) throws ParseException {
        HashMap<String, String> result = new HashMap<>();
        String msg;
        String error = "true";

        PhoneNumber phoneNumber = phoneNumberRepository.findPhoneNumberByNumber(number);
        if(phoneNumber == null){
            msg = "Invalid number";
        }
        else{
            if(phoneNumber.getStatus().equals("active")){
                msg = "Already an active number";
            }
            else{
                if(phoneNumber.getUserId() == null){
                    if(customerId == null) {
                        msg = "Cannot activate number without a user";
                    }
                    else{
                        User user = userRepository.findUserById(Integer.parseInt(customerId));
                        if(user == null){
                            msg = "Invalid customer id";
                        }
                        else{
                            phoneNumber.setStatus("active");
                            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                            phoneNumber.setStartDate(formatter.parse(formatter.format(new Date())));
                            phoneNumber.setUserId(Integer.parseInt(customerId));
                            phoneNumberRepository.save(phoneNumber);

                            List<PhoneNumber> phoneNumbers = user.getPhoneNumbers();
                            phoneNumbers.add(phoneNumber);
                            userRepository.save(user);
                            msg = "Number activated";
                            error = "false";
                        }
                    }
                }
                else {
                    phoneNumber.setStatus("active");
                    phoneNumberRepository.save(phoneNumber);
                    msg = "Number activated";
                    error = "false";
                }
            }
        }
        result.put("error", error);
        result.put("msg", msg);
        return result;
    }

    /***
     * This method is used to deactivate a phone number.
     * @param number
     * @return
     */
    public HashMap<String, String> deactivate(String number){
        HashMap<String, String> result = new HashMap<>();
        String msg;
        String error = "true";

        PhoneNumber phoneNumber = phoneNumberRepository.findPhoneNumberByNumber(number);
        if(phoneNumber == null){
            msg = "Invalid number";
        }
        else{
            if(phoneNumber.getStatus().equals("inactive")){
                msg = "Already an inactive number";
            }
            else{
                phoneNumber.setStatus("inactive");
                phoneNumberRepository.save(phoneNumber);
                msg = "Number deactivated";
                error = "false";

            }
        }
        result.put("error", error);
        result.put("msg", msg);
        return result;
    }
}
