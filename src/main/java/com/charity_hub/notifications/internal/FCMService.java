package com.charity_hub.notifications.internal;

import com.charity_hub.notifications.NotificationApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.messaging.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FCMService implements NotificationApi {
    private final ObjectMapper objectMapper;

    public FCMService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void notifyDevices(List<String> tokens, String title, String body) {
        for (String token : tokens) {
            Message message = buildMessage(title, body)
                    .setToken(token)
                    .build();
            try {
                FirebaseMessaging.getInstance().send(message);
            } catch (FirebaseMessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void notifyTopicSubscribers(String topic, String event, Object extraJsonData, String title, String body) {
        Message message;
        String payload;
        try {
            payload = objectMapper.writeValueAsString(extraJsonData);
        } catch (JsonProcessingException e) {
            payload = "{}";
        }
        message = buildMessage(title, body)
                .setTopic(topic)
                .putData("topic", topic)
                .putData("event", event)
                .putData("data", payload)
                .build();


        try {
            FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Subscribe tokens to a topic.
     *
     * @param topic  The topic to subscribe to
     * @param tokens The list of tokens to subscribe
     */
    @Override
    public void subscribeToTopic(String topic, List<String> tokens) {
        TopicManagementResponse response;
        try {
            response = FirebaseMessaging.getInstance().subscribeToTopic(tokens, topic);
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.getSuccessCount() + " tokens were subscribed successfully");
    }

    private Message.Builder buildMessage(String title, String body) {
        Message.Builder builder = Message.builder()
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(body)
                        .build());
        androidConfig(builder);
        apnsConfig(builder);
        return builder;
    }

    private void apnsConfig(Message.Builder builder) {
        builder.setApnsConfig(
                ApnsConfig.builder()
                        .setAps(Aps.builder().build())
                        .build()
        );
    }

    private void androidConfig(Message.Builder builder) {
        builder.setAndroidConfig(
                AndroidConfig.builder()
                        .setTtl(3600 * 1000L)
                        .setNotification(AndroidNotification.builder()
                                .setIcon("stock_ticker_update")
                                .setColor("#f45342")
                                .build()
                        ).build()
        );
    }
}