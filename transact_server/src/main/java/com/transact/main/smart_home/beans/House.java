package com.transact.main.smart_home.beans;

import java.util.ArrayList;

/**
 * Created by patilsp on 10/14/2017.
 */

public class House {
    private int house_id;
    private String house_name;
    private int owner_id;
    private String authentication_code;

    public House() {
    }

    public House(int house_id, String house_name, int owner_id, String authentication_code) {
        this.house_id = house_id;
        this.house_name = house_name;
        this.owner_id = owner_id;
        this.authentication_code = authentication_code;
    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public String getHouse_name() {
        return house_name;
    }

    public void setHouse_name(String house_name) {
        this.house_name = house_name;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getAuthentication_code() {
        return authentication_code;
    }

    public void setAuthentication_code(String authentication_code) {
        this.authentication_code = authentication_code;
    }


}
