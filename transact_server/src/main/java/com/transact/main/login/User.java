package com.transact.main.login;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by patilsp on 10/12/2017.
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -8999330441474696575L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    int user_id;
    String primary_mobile_number;
    String display_name;
    String first_name;
    String family_name;
    String email_id;
    String pan_number;
    String pan_document;
    String gst_document;
    String country_code;
    String password;
    String created_at;
    String updated_at;
    String profile_photo_url;
    String date_of_birth;
    GENDER gender;
    LOGIN_TYPE login_type; // FB, GMAIL, OTHER
    char has_special_accesses;
    char has_cart;
    char is_active;

    String notification_token;

    public enum LOGIN_TYPE
    {
        FB,
        GMAIL,
        OTHER
    }

    enum GENDER{
        MALE,
        FEMALE
    }

    public User()
    {

    }

    public User(int user_id, String primary_mobile_number, String display_name, String first_name, String family_name, String email_id, String pan_number, String pan_document, String gst_document, String country_code, String password, String created_at, String updated_at, String profile_photo_url, LOGIN_TYPE login_type, char has_special_accesses, char has_cart, char is_active) {
        this.user_id = user_id;
        this.primary_mobile_number = primary_mobile_number;
        this.display_name = display_name;
        this.first_name = first_name;
        this.family_name = family_name;
        this.email_id = email_id;
        this.pan_number = pan_number;
        this.pan_document = pan_document;
        this.gst_document = gst_document;
        this.country_code = country_code;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.profile_photo_url = profile_photo_url;
        this.login_type = login_type;
        this.has_special_accesses = has_special_accesses;
        this.has_cart = has_cart;
        this.is_active = is_active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getPrimary_mobile_number() {
        return primary_mobile_number;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public String getPan_number() {
        return pan_number;
    }

    public String getPan_document() {
        return pan_document;
    }

    public String getGst_document() {
        return gst_document;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getPassword() {
        return password;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getProfile_photo_url() {
        return profile_photo_url;
    }

    public LOGIN_TYPE getLogin_type() {
        return login_type;
    }

    public char getHas_special_accesses() {
        return has_special_accesses;
    }

    public char getHas_cart() {
        return has_cart;
    }

    public char getIs_active() {
        return is_active;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPrimary_mobile_number(String primary_mobile_number) {
        this.primary_mobile_number = primary_mobile_number;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public void setPan_number(String pan_number) {
        this.pan_number = pan_number;
    }

    public void setPan_document(String pan_document) {
        this.pan_document = pan_document;
    }

    public void setGst_document(String gst_document) {
        this.gst_document = gst_document;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setProfile_photo_url(String profile_photo_url) {
        this.profile_photo_url = profile_photo_url;
    }

    public void setLogin_type(LOGIN_TYPE login_type) {
        this.login_type = login_type;
    }

    public void setHas_special_accesses(char has_special_accesses) {
        this.has_special_accesses = has_special_accesses;
    }

    public void setHas_cart(char has_cart) {
        this.has_cart = has_cart;
    }

    public void setIs_active(char is_active) {
        this.is_active = is_active;
    }
}
