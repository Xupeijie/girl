package com.xpj.girl.service;

import com.xpj.girl.ReslutEnum.ResultEnum;
import com.xpj.girl.exception.GirlException;
import com.xpj.girl.pojo.Girl;
import com.xpj.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by peijie on 2017/12/25.
 */
@Service
@Transactional
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public void insertTwo(){
        Girl girl = new Girl();
        girl.setAge(17);
        girl.setCupSize("d");
        girlRepository.save(girl);

        Girl girl1 = new Girl();
        girl1.setAge(27);
        girl1.setCupSize("f");
        girlRepository.save(girl1);
    }

    public void getAge(Integer id) throws  Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age<10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10 &&age<16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        throw new GirlException(ResultEnum.HIGH_SCHOOL);
    }
}
