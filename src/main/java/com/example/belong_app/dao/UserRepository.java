package com.example.belong_app.dao;

import com.example.belong_app.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

/***
 * User repository
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserById(Integer id);
    Iterable<User> findUserByFirstNameLikeOrLastNameLike(String firstName, String lastName);
    User findUserByFirstNameAndLastNameAndDob(String firstName, String lastName, Date dob);
}