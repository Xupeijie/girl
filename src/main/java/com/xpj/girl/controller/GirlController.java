package com.xpj.girl.controller;

import com.xpj.girl.pojo.Girl;
import com.xpj.girl.pojo.Result;
import com.xpj.girl.repository.GirlRepository;
import com.xpj.girl.service.GirlService;
import com.xpj.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by peijie on 2017/12/25.logger
 */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        Result<Girl> girlResult = new Result<>();
        if(bindingResult.hasErrors()){
            return null;
//            return ResultUtil.error(0,bindingResult.getFieldError().getDefaultMessage());
        }else{
            return ResultUtil.success(girlRepository.save(girl));
        }

    }

    /**
     * 查询一个女生
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindById(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 删除一个女生
     * @return
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDeleteById(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 更新一个女生
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdateById(@PathVariable("id") Integer id,
                               @RequestParam("age") Integer age,
                               @RequestParam("cupSize") String cupSize){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setId(id);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 查询一个女生
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 添加女生
     * @return
     */
    @PostMapping(value = "/girls/two")
    public void girlAddTwo(){
        girlService.insertTwo();
    }

    /**
     *描述: 通过年龄判断不同情况
     */
    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws  Exception{
        girlService.getAge(id);
    }
}
