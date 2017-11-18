package com.transact.main.smart_home.beans;

import java.io.Serializable;

/**
 * Created by patilsp on 10/14/2017.
 */

public class SHUser implements Serializable {


    int house_id;
    String mobile_number;
    String user_name;

    public SHUser() {
    }

    public SHUser(int house_id, String mobile_number, String user_name) {
        this.house_id = house_id;
        this.mobile_number = mobile_number;
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public int getHouse_id() {
        return house_id;
    }

    @Override
    public String toString() {
        return "SHUser{" +
                "house_id=" + house_id +
                ", mobile_number='" + mobile_number + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
