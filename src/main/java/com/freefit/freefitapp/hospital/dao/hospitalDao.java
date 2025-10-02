package com.freefit.freefitapp.hospital.dao;

import com.freefit.freefitapp.vo.HospitalVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface hospitalDao {

    public List<HospitalVO> selectNearHospital(@Param("lat") double lat, @Param("lon") double lon) throws Exception;

    public List<HospitalVO> selectPopularHospital() throws Exception;

    public List<HospitalVO> selectSpecialHospital() throws Exception;

    public List<HospitalVO> select24HoursHospital() throws Exception;

    HospitalVO selectHospitalDetail(@Param("id") int id) throws Exception;
}
