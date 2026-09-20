package com.example.chat.message;

import com.example.chat.auth.ChatUserPrincipal;
import com.example.chat.message.dto.MessagePageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat/rooms/{roomId}/messages")
@RequiredArgsConstructor
public class MessageHistoryController {

    private final ChatMessageService chatMessageService;

    @GetMapping
    public MessagePageResponse history(@PathVariable Long roomId,
                                       @RequestParam(required = false) Long before,
                                       @RequestParam(defaultValue = "50") int size,
                                       @AuthenticationPrincipal ChatUserPrincipal principal
                                       ) {
        return chatMessageService.history(roomId, principal, before, size);
    }
}
