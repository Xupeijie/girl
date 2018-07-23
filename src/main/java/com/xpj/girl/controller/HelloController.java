package com.xpj.girl.controller;

import com.xpj.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by peijie on 2017/12/25.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

   /* @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;*/

    @Autowired
    private GirlProperties girlPeoperties;

//    @RequestMapping(value = {"/hi","/say/{id}"},method = RequestMethod.GET)
    @GetMapping(value = "/say/{id}")
    public String sqy(@PathVariable("id") Integer id, @RequestParam(value = "ids",required =  false,defaultValue = "0") Integer ids){
        return "id:" + id+" ids:"+ids;
    }

}
