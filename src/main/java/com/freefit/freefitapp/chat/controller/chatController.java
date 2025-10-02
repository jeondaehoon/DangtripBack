package com.freefit.freefitapp.chat.controller;

import com.freefit.freefitapp.chat.service.chatService;
import com.freefit.freefitapp.vo.ChatMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class chatController {
    @Autowired
    private chatService service;

    @PostMapping("/chat/join")
    @ResponseBody
    public Map<String, Object> joinChatRoom(@RequestBody Map<String, Object> req,
                                            @RequestHeader("Authorization") String token) throws Exception {
        Long groupId = Long.valueOf(req.get("groupId").toString());
        String userId = service.extractUserIdFromToken(token);
        Long roomId = service.joinChatRoom(groupId, userId);
        return Map.of("roomId", roomId);
    }

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/chat/{roomId}")
    public ChatMessageVO sendMessage(@DestinationVariable Long roomId,
                                     ChatMessageVO message) {
        message.setRoomId(roomId);
        message.setCreatedAt(LocalDateTime.now().toString());
        System.out.println("💬 서버 수신: room=" + roomId + " user=" + message.getUserId() + " content=" + message.getContent());
        return message;
    }
}
