package com.example.chat.message;

import com.example.chat.message.dto.MessageResponse;
import com.example.chat.message.dto.RoomEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatMessagePublisher {

    public static final String LOBBY_TOPIC = "/topic/rooms";
    public final SimpMessagingTemplate simpMessagingTemplate;

    public static String roomTopic(Long roomId) {
        return "/topic/room/" + roomId;
    }

    public void publishMessage(MessageResponse message) {
        simpMessagingTemplate.convertAndSend(roomTopic(message.roomId()),message);
    }

    public void publishRoomEvent(RoomEvent event) {
        simpMessagingTemplate.convertAndSend(LOBBY_TOPIC,event);
    }
}
