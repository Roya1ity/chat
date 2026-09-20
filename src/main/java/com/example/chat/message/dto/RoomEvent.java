package com.example.chat.message.dto;

import com.example.chat.room.dto.RoomResponse;

public record RoomEvent(
        RoomEventType type,
        RoomResponse room
) {
}
