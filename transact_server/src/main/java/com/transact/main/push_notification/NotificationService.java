package com.transact.main.push_notification;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	
	private static final String FIREBASE_SERVER_KEY = "AAAAiVQz4sg:APA91bH9sZoOiAVYze34jnGEJmjCZopdrD1rR8k615Kdwnw2crpqTe2f7o4q2UBfUkq-OLT45QsMNzAdiK-p8hhvFjNl0lRc_oYMydEgdEniCKiKLo526sUAQvMd7QYIbthvPLiUFr55";

    @Async
    public CompletableFuture<NotificationResponse> send(HttpEntity<String> entity) {

        RestTemplate restTemplate = new RestTemplate();

        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
        interceptors.add(new HeaderInterceptor("Content-Type", "application/json"));
        restTemplate.setInterceptors(interceptors);

        NotificationResponse notificationResponse = restTemplate.postForObject("https://fcm.googleapis.com/fcm/send", entity, NotificationResponse.class);

        return CompletableFuture.completedFuture(notificationResponse);
    }


}
