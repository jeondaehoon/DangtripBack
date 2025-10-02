package com.freefit.freefitapp.chat.service;

import com.freefit.freefitapp.chat.dao.chatDao;
import com.freefit.freefitapp.util.JwtUtil;
import com.freefit.freefitapp.vo.ChatMessageVO;
import com.freefit.freefitapp.vo.ChatRoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class chatService {

    @Autowired
    private chatDao dao;

    @Autowired
    private JwtUtil jwtUtil;

    // JWT에서 userId 추출
    public String extractUserIdFromToken(String token) throws Exception {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        return jwtUtil.extractUsername(token);
    }

    // 그룹 참여
    public Long joinChatRoom(Long groupId, String userId) throws Exception {
        ChatRoomVO room = dao.findRoomIdByGroupId(groupId);

        if (room == null) {
            dao.insertChatRoom(groupId);
            room = dao.findRoomIdByGroupId(groupId);
        }

        Long roomId = room.getRoomId();

        // 이미 참여자 있으면 무시
        try {
            dao.insertChatMember(roomId, userId);
        } catch (Exception e) {
            System.out.println("회원 이미 참여했거나 insert 실패: " + e.getMessage());
        }

        return roomId;
    }

    // 메시지 저장
    public void insertMessage(ChatMessageVO message) throws Exception {
        dao.insertMessage(message);
    }

    // 메시지 불러오기
    public List<ChatMessageVO> getMessagesRoom(Long roomId) throws Exception {
        return dao.getMessagesRoom(roomId);
    }
}
