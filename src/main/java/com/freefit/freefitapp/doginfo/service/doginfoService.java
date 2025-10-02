package com.freefit.freefitapp.doginfo.service;

import com.freefit.freefitapp.doginfo.dao.doginfoDao;
import com.freefit.freefitapp.vo.ArrayDogInfoVO;
import com.freefit.freefitapp.vo.CategoryVO;
import com.freefit.freefitapp.vo.DogInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class doginfoService {

    @Autowired
    doginfoDao dao;

    public List<DogInfoVO> selectDogBreed(DogInfoVO vo) throws Exception {
        return dao.selectDogBreed(vo);
    }

    public boolean checknickName(DogInfoVO vo) throws Exception {
        return dao.checknickName(vo) > 0;
    }

    public boolean saveDogInfo(ArrayDogInfoVO vo) throws Exception {
        if (vo.getDogs() != null && !vo.getDogs().isEmpty()) {
            int saveCount = 0;
            for (DogInfoVO dog : vo.getDogs()) {

                // 상위 userId/닉네임 세팅
                dog.setUserId(vo.getUserId());
                dog.setNickName(vo.getNickName());

                // debug: insert 직전 값 확인
                System.out.println(">>> dogId: " + dog.getDogId());
                System.out.println(">>> userId: " + dog.getUserId());
                System.out.println(">>> nickName: " + dog.getNickName());

                // dogId 없으면 UUID 생성
                if (dog.getDogId() == null || dog.getDogId().isEmpty()) {
                    dog.setDogId(UUID.randomUUID().toString());
                }

                // DB insert
                saveCount += dao.saveDogInfo(dog);
            }
            return saveCount > 0;
        }
        return false;
    }

    public List<CategoryVO> selectCatList(CategoryVO vo) throws Exception {
        return dao.selectCatList(vo);
    }
}
