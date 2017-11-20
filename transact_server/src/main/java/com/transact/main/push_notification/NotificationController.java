package com.transact.main.push_notification;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/demo")
public class NotificationController {
	
	private static final Logger log = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    NotificationService notificationsService;

    @RequestMapping(value = "/send", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> send() throws JSONException {
    	JSONObject body = new JSONObject();
        // JsonArray registration_ids = new JsonArray();
        // body.put("registration_ids", registration_ids);
        body.put("to", "fj51MxGoRYg:APA91bEsflIct3Q38ctoArZMyGDiS87B_Voh-1Tj_IHYMSETFk2sdCT9B2dN46EVdJeI9pUAC-W4MUD5YIfe-Dm0i48Dt2oVKCXUZh3JU2-NHCdYhondCrBAK7qk6btlGncBTWPc1w7j");
        body.put("priority", "high");
        // body.put("dry_run", true);

        JSONObject notification = new JSONObject();
        notification.put("body", "body string here");
        notification.put("title", "title string here");
        // notification.put("icon", "myicon");

        JSONObject data = new JSONObject();
        data.put("key1", "value1");
        data.put("key2", "value2");

        body.put("notification", notification);
        body.put("data", data);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<NotificationResponse> pushNotification= notificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
        	NotificationResponse notificationResponse = pushNotification.get();
            if (notificationResponse.getSuccess() == 1) {
                log.info("push notification sent ok!");
            } else {
                log.error("error sending push notifications: " + notificationResponse.toString());
            }
            return new ResponseEntity<>(notificationResponse.toString(), HttpStatus.OK);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("the push notification cannot be send.", HttpStatus.BAD_REQUEST);
    }
    }
