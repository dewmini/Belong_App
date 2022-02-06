package com.example.belong_app.model;

import javax.persistence.*;
import java.util.Date;

/***
 * Phone number model
 */
@Entity
@Table(name = "phoneNumber")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String number;
    private String status;
    private Date startDate;
    private Integer userId;

    public PhoneNumber(String number, String status, Date startDate, Integer userId) {
        this.number = number;
        this.status = status;
        this.startDate = startDate;
        this.userId = userId;
    }

    public PhoneNumber() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public String getStatus() {
        return status;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
