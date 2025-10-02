package com.freefit.freefitapp.hospital.service;

import com.freefit.freefitapp.hospital.dao.hospitalDao;
import com.freefit.freefitapp.vo.HospitalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class hospitalService {
    @Autowired
    hospitalDao dao;

    public List<HospitalVO> selectNearHospital(double lat, double lon) throws Exception{
        return dao.selectNearHospital(lat, lon);
    }

    public List<HospitalVO> selectPopularHospital() throws Exception{
        return dao.selectPopularHospital();
    }

    public List<HospitalVO> selectSpecialHospital() throws Exception {
        return dao.selectSpecialHospital();
    }

    public List<HospitalVO> select24HoursHospital() throws Exception {
        return dao.select24HoursHospital();
    }

    public HospitalVO selectHospitalDetail(int id) throws Exception {
        return dao.selectHospitalDetail(id);
    }
}
