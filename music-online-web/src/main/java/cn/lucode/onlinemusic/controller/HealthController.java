package cn.lucode.onlinemusic.controller;

import cn.lucode.onlinemusic.service.CrawlManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yunfeng.lu on 2017/9/18.
 */
@RestController
@RequestMapping("/health")
public class HealthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HealthController.class);
    @GetMapping("/check")
    public String health(){
        return "Ok";
    }

}
