package com.xpj.girl.repository;

import com.xpj.girl.pojo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by peijie on 2017/12/25.
 */
@Component
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通过年龄查询
    public List<Girl> findByAge(Integer age);
}
