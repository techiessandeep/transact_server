package com.transact.main.login;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;

import com.transact.main.push_notification.NotificationResponse;
import com.transact.main.push_notification.NotificationService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class LoginController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    NotificationService notificationsService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody User user) {
        if (user == null) {
            System.out.println("User object is null, can com.transact.main.login ");
        }

        System.out.println("User trying to login");
        user.setDisplay_name("Patil, Sandeep");

        userRepository.save(user);
        try {
            notificationResp();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody User user) {
        if (user == null) {
            System.out.println("User object is null, can com.transact.main.login ");
        }

        System.out.println("User trying to Register");

        userRepository.save(user);
        try {
            notificationResp();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    void notificationResp() throws JSONException {
        JSONObject body = new JSONObject();
        // JsonArray registration_ids = new JsonArray();
        // body.put("registration_ids", registration_ids);
        body.put("to", "e_TBrWMl5PU:APA91bER585LTvFzESmoL_1yp8wOoz8RvOS7nQYL4W3BhXLhE1ZfhE8jeAUJTaIfW_tosg6cxjHrpaY5KDItTxk55fzOXXQuW3EAUWA_bLz7AnZXpxekeceRmtLK_4J7KqvTKPlLeApO");
        body.put("priority", "high");
        // body.put("dry_run", true);

        JSONObject notification = new JSONObject();
        notification.put("body", "New User Registered");
        notification.put("title", "title string here");
        // notification.put("icon", "myicon");

        JSONObject data = new JSONObject();
        data.put("key1", "value1");
        data.put("key2", "value2");

        body.put("notification", notification);
        body.put("data", data);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<NotificationResponse> pushNotification = notificationsService.send(request);

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
        User user2 = new User();
        user2.setDisplay_name("Sandeep");
        user2.setEmail_id("san27deep");
        user2.setLogin_type(User.LOGIN_TYPE.FB);

        return user2;
    }

    @RequestMapping(value = "/{firstcar}", method = RequestMethod.POST)
    public HttpStatus get(@PathVariable String firstcar) {
        User user2 = new User();
        user2.setDisplay_name("Sandeep");
        user2.setEmail_id("san27deep");
        user2.setLogin_type(User.LOGIN_TYPE.FB);
//        return new ResponseEntity<Car>(car, HttpStatus.OK);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/wc", method = RequestMethod.POST)
    public HttpStatus get() {
        User user2 = new User();
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
        User user2 = new User();
        user2.setDisplay_name("Sandeep");
        user2.setEmail_id("san27deep");
        user2.setLogin_type(User.LOGIN_TYPE.FB);
        return new ResponseEntity<User>(user2, HttpStatus.OK);
    }

}
