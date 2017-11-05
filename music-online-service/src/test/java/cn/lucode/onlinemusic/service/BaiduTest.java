package cn.lucode.onlinemusic.service;

import cn.lucode.exception.HttpProcessException;
import cn.lucode.onlinemusic.service.api.ICrawlManagerService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author yunfeng.lu
 * @create 2017/11/5.
 */
public class BaiduTest extends BaseTest {

    @Autowired
    private ICrawlManagerService crawlManagerService;

    @Test
    public void crawlManagerServiceTest() {
        try {
            Map map = crawlManagerService.getBaiduMusic("http://music.baidu.com/top/dayhot");
            Assert.assertNotNull(map);
            System.out.println(map);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }
    }

}
