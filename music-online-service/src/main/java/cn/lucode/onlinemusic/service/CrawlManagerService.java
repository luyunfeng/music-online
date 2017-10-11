package cn.lucode.onlinemusic.service;

import cn.lucode.exception.HttpProcessException;
import cn.lucode.onlinemusic.service.api.ICrawlManagerService;
import cn.lucode.onlinemusic.utils.baidu.BaiduMusicUtil;
import cn.lucode.onlinemusic.utils.model.MusicModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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

    public Map<String,Object> getBaiduMusic(String url) throws HttpProcessException {
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
                musicModel.setTitle(element.attr("title"));
                musicModel.setUrl(songUrl);
                musicModelList.add(musicModel);
            }
        }
        res.put("musicModelList",musicModelList);
        return res;
    }

}
