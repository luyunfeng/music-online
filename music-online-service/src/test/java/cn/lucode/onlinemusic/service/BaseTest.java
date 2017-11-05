package cn.lucode.onlinemusic.service;

import cn.lucode.StartApplication;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yunfeng.lu
 * @create 2017/11/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=StartApplication.class,webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class BaseTest {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
}
