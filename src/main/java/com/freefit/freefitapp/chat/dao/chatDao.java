package com.freefit.freefitapp.chat.dao;

import com.freefit.freefitapp.vo.ChatMessageVO;
import com.freefit.freefitapp.vo.ChatRoomVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface chatDao {

    public ChatRoomVO findRoomIdByGroupId(Long groupId);

    public int insertChatRoom(Long groupId);

    public int checkMemberExists(@Param("roomId") Long roomId,
                                 @Param("userId") String userId);

    public int insertChatMember(@Param("roomId") Long roomId,
                                @Param("userId") String userId);

    // 메시지 저장
    public void insertMessage(ChatMessageVO message) throws Exception;

    // 방 메시지 전체 조회
    public List<ChatMessageVO> getMessagesRoom(Long roomId) throws Exception;
}
