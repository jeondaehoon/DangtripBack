package com.freefit.freefitapp.doginfo.dao;

import com.freefit.freefitapp.vo.CategoryVO;
import com.freefit.freefitapp.vo.DogInfoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface doginfoDao {

    public List<DogInfoVO> selectDogBreed(DogInfoVO vo) throws Exception;

    public int checknickName(DogInfoVO vo) throws Exception;

    public int saveDogInfo(DogInfoVO vo) throws Exception;

    public List<CategoryVO> selectCatList(CategoryVO vo) throws Exception;
}
