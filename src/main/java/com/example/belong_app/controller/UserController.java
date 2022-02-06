package com.example.belong_app.controller;

import com.example.belong_app.dao.UserRepository;
import com.example.belong_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/***
 * User controller
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /***
     * This is used to create a user
     * @param firstName
     * @param lastName
     * @param email
     * @param address
     * @param gender
     * @param DOB
     * @return
     */
    @PostMapping("/addUser")
    public String addCustomer(@RequestParam String firstName, @RequestParam String lastName,@RequestParam String email, @RequestParam String address,
        @RequestParam String gender, @RequestParam Date DOB) {
        User customer = new User(firstName,lastName,gender,address,email, DOB);
        userRepository.save(customer);
        return "Added new customer";
    }

    /***
     * This is used to get all the users in the system
     * @return
     */
    @GetMapping("/listUsers")
    public Iterable<User> getCustomers() {
        return userRepository.findAll();
    }

    /***
     * This is used to find a user by customer id
     * @param id
     * @return
     */
    @GetMapping("/findUser")
    public ModelAndView findCustomerById(@RequestParam Integer id) {

        User user =  userRepository.findUserById(id);
        ModelAndView model = new ModelAndView("user/index");
        model.addObject("user",user);
        if(user == null){
            model.addObject("error","Invalid Customer Id");
        }
        return model;
    }

    /***
     * This is used to find a user by first name or last name
     * @param firstName
     * @param lastName
     * @return
     */
    @GetMapping("/findUserByName")
    public Iterable<User> findCustomerByName(@RequestParam String firstName, @RequestParam String lastName) {
        return userRepository.findUserByFirstNameLikeOrLastNameLike(firstName, lastName);
    }

    /***
     * This is used to search a user by firstname, last name and dob
     * @param firstName
     * @param lastName
     * @param DOB
     * @return
     */
    @GetMapping("/findUserByNameAndDOB")
    public ModelAndView findUserByNameAndDOB(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Date DOB) {

        User user = userRepository.findUserByFirstNameAndLastNameAndDob(firstName, lastName, DOB);
        ModelAndView model = new ModelAndView("user/index");
        model.addObject("user", user);
        if(user == null){
            model.addObject("error","No customer found.");
        }
        return model;
    }
}
