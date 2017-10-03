package cn.lucode.onlinemusic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yunfeng.lu on 2017/9/18.
 */
@RestController
@RequestMapping("health")
public class HealthController {

    @GetMapping("/check")
    public String health(){
        return "Ok";
    }

}
