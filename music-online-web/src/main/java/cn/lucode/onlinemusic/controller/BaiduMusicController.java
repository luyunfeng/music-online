package cn.lucode.onlinemusic.controller;

import cn.lucode.exception.HttpProcessException;
import cn.lucode.onlinemusic.service.api.ICrawlManagerService;
import cn.lucode.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTML;

/**
 * Created by yunfeng.lu on 2017/10/2.
 */
@RestController
@RequestMapping("/baidu")
public class BaiduMusicController {
    @Autowired
    ICrawlManagerService crawlManagerService;
    private static final Logger LOGGER = LoggerFactory.getLogger(BaiduMusicController.class);

    @GetMapping("/start")
    public Object start(@RequestParam(value = "url") String url) {
        try {
            return crawlManagerService.getBaiduMusic(url);
        } catch (HttpProcessException e) {
            return "false";
        } catch (Exception e) {
            return "false";
        }
    }
}
