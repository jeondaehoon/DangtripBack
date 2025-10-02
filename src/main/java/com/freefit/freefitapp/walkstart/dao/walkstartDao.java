    package com.freefit.freefitapp.walkstart.dao;

    import com.freefit.freefitapp.vo.EmergencyLogVO;
    import com.freefit.freefitapp.vo.EmergencyVO;
    import com.freefit.freefitapp.vo.WalkLogVO;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository
    public interface walkstartDao {

        public List<EmergencyVO> selectEmergencyList() throws Exception;

        public int insertWalkLog(WalkLogVO vo) throws Exception;

        public int getLastWalkId() throws Exception;

        public int insertEmergencyLog(EmergencyLogVO vo) throws Exception;
    }
