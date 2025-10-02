package com.freefit.freefitapp.walkstart.service;

import com.freefit.freefitapp.vo.EmergencyLogVO;
import com.freefit.freefitapp.vo.EmergencyVO;
import com.freefit.freefitapp.vo.WalkEndVO;
import com.freefit.freefitapp.vo.WalkLogVO;
import com.freefit.freefitapp.walkstart.dao.walkstartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class walkstartService {
    @Autowired
    walkstartDao dao;

    public List<EmergencyVO> selectEmergencyList() throws Exception {
        return dao.selectEmergencyList();
    }

    public int endWalk(WalkEndVO vo) throws Exception {
        // WALK_LOG저장
        WalkLogVO walkLog = new WalkLogVO();
        walkLog.setUserId(vo.getUserId());
        walkLog.setStartTime(vo.getStartTime());
        walkLog.setEndTime(vo.getEndTime());
        walkLog.setDuration(vo.getDuration());

        int result = dao.insertWalkLog(walkLog);
        if (result <= 0) return 0;

        // WALK_LOG ID가져오기
        int walkId = dao.getLastWalkId();

        // EMERGENCY_LOG 저장
        if(vo.getEmergency() != null) {
            EmergencyLogVO em = new EmergencyLogVO();
            em.setWalkId(walkId);

            // symptomName
            String symptomName = vo.getEmergency().getSymptomName();
            if (symptomName == null || symptomName.trim().isEmpty()) {
                em.setSymptomName("기타 증상");
            } else {
                em.setSymptomName(symptomName);
            }

            // severity
            String severity = vo.getEmergency().getSeverity();
            if (severity == null || severity.trim().isEmpty()) {
                em.setSeverity("확인 필요");
            } else {
                em.setSeverity(severity);
            }

            // description
            String description = vo.getEmergency().getDescription();
            if (description == null || description.trim().isEmpty()) {
                em.setDescription("증상 상세 내용 없음");
            } else {
                em.setDescription(description);
            }

            // actionGuide: 반려동물에 맞게 수정
            String actionGuide = vo.getEmergency().getActionGuide();
            if (actionGuide == null || actionGuide.trim().isEmpty()) {
                em.setActionGuide("긴급상황 시 가까운 동물병원에 연락하거나 이동하세요.");
            } else {
                em.setActionGuide(actionGuide);
            }

            dao.insertEmergencyLog(em);
        }
        return walkId;
    }
}
