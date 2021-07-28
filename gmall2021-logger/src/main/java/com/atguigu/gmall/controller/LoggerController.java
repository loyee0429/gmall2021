package com.atguigu.gmall.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//=@Controller+@ResponseBody
@Slf4j
public class LoggerController {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @RequestMapping("/test")
    public String test1() {
        System.out.println("1111111111");
        return "success";
    }
@RequestMapping("/applog")
    public String getLogger(@RequestParam("param") String logstr){
        //将日志数据打印到控制台&写入日志文件
        log.info(logstr);
        //写入kafka
        kafkaTemplate.send("ods_base_log",logstr);
        return "success";
    }
}
