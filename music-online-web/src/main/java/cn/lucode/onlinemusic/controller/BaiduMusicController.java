package cn.lucode.onlinemusic.controller;

import cn.lucode.exception.HttpProcessException;
import cn.lucode.onlinemusic.service.api.ICrawlManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yunfeng.lu on 2017/10/2.
 */
@RestController
@RequestMapping("/baidu")
public class BaiduMusicController {
    @Autowired
    ICrawlManagerService crawlManagerService;

    @GetMapping("/start")
    public Object start(@RequestParam(value = "url")String url){
        try {
            return crawlManagerService.getBaiduMusic(url);
        } catch (HttpProcessException e) {
            return null;
        } catch (Exception e){
            return null;
        }
    }
}
