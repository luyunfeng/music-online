package cn.lucode.onlinemusic.service.api;

import cn.lucode.fastdev.exception.HttpProcessException;

import java.util.Map;

/**
 * Created by yunfeng.lu on 2017/9/25.
 */
public interface ICrawlManagerService {
     Map getBaiduMusic(String url) throws HttpProcessException;
}
