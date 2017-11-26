package cn.lucode.onlinemusic.service;

import cn.lucode.fastdev.annotation.LogAuto;
import cn.lucode.fastdev.exception.HttpProcessException;
import cn.lucode.onlinemusic.service.api.ICrawlManagerService;
import cn.lucode.onlinemusic.utils.AppCode;
import cn.lucode.onlinemusic.utils.baidu.BaiduMusicUtil;
import cn.lucode.onlinemusic.utils.cache.SongCacheUtil;
import cn.lucode.onlinemusic.utils.model.MusicModel;
import cn.lucode.fastdev.util.LogUtil;
import cn.lucode.fastdev.util.UUIDGenerator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yunfeng.lu on 2017/9/25.
 */
@Service
public class CrawlManagerService implements ICrawlManagerService {

    @Autowired
    private SongCacheUtil songCacheUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(CrawlManagerService.class);


    @Override
    @LogAuto(AppCode.musicOnline)
    public Map<String,Object> getBaiduMusic(String url) throws HttpProcessException {
        //url="http://music.baidu.com/top/dayhot";
        Map<String,Object> res=new HashMap<>();
        BaiduMusicUtil baiduMusicUtil=new BaiduMusicUtil(url);

        String html=baiduMusicUtil.getHtml();

        Document doc = Jsoup.parse(html);
        Elements songResult =doc.select(".song-title a");
        Elements authorResult=doc.select("singer a");
        List<MusicModel> musicModelList=new ArrayList<>();

        for (Element element:songResult){
            String songUrl="http://music.baidu.com"+element.attr("href");
            if(songUrl.indexOf("song")!=-1){
                MusicModel musicModel=new MusicModel();
                musicModel.setId(UUIDGenerator.generate());
                musicModel.setTitle(element.attr("title"));
                musicModel.setUrl(songUrl);
                musicModelList.add(musicModel);
                LogUtil.info(LOGGER,"musicModel:{0}",musicModel.toString());
                songCacheUtil.saveModel(musicModel);
            }
        }
        res.put("musicModelList",musicModelList);
        return res;
    }

}
