package com.transact.main.login;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class LoginController {
    StringBuffer str;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody User user) {
        if (user == null) {
            System.out.println("User object is null, can com.transact.main.login ");
        }

        System.out.println("User trying to login");
        user.setDisplay_name("Patil, Sandeep");

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody User user) {
        if (user == null) {
            System.out.println("User object is null, can com.transact.main.login ");
        }

        System.out.println("User trying to Register");

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<User> updateMobileNumber(@RequestBody User user) {
        if (user == null) {
            System.out.println("User object is null, can com.transact.main.login ");
        }

        System.out.println("User trying to update profile");

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    @RequestMapping(value = "/{greeting}", method = RequestMethod.GET)
    public User greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("IN greeting");
        User user2= new User();
        user2.setDisplay_name("Sandeep");
        user2.setEmail_id("san27deep");
        user2.setLogin_type(User.LOGIN_TYPE.FB);

        return user2;
    }

    @RequestMapping(value = "/{firstcar}", method = RequestMethod.POST)
    public HttpStatus get(@PathVariable String firstcar) {
        User user2= new User();
        user2.setDisplay_name("Sandeep");
        user2.setEmail_id("san27deep");
        user2.setLogin_type(User.LOGIN_TYPE.FB);
//        return new ResponseEntity<Car>(car, HttpStatus.OK);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/wc", method = RequestMethod.POST)
    public HttpStatus get() {
        User user2= new User();
        user2.setDisplay_name("Sandeep");
        user2.setEmail_id("san27deep");
        user2.setLogin_type(User.LOGIN_TYPE.FB);
//        return new ResponseEntity<Car>(car, HttpStatus.OK);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/{cars}", method = RequestMethod.POST)
    public ResponseEntity<User> update(@RequestBody User user) {
        if (user != null) {

        }
        System.out.println("In update ");
        User user2= new User();
        user2.setDisplay_name("Sandeep");
        user2.setEmail_id("san27deep");
        user2.setLogin_type(User.LOGIN_TYPE.FB);
        return new ResponseEntity<User>(user2, HttpStatus.OK);
    }

}
