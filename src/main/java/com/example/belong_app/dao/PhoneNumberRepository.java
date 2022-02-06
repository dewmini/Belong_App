package com.example.belong_app.dao;

import com.example.belong_app.model.PhoneNumber;
import org.springframework.data.repository.CrudRepository;

/***
 * Phone number repository
 */
public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Integer> {

    PhoneNumber findPhoneNumberById(Integer id);
    PhoneNumber findPhoneNumberByNumber(String number);
}