import cn.lucode.exception.HttpProcessException;
import cn.lucode.onlinemusic.utils.baidu.BaiduMusicUtil;
import cn.lucode.onlinemusic.utils.model.MusicModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yunfeng.lu on 2017/10/3.
 */
public class BaiduTest {

    @Test
    public void test() throws HttpProcessException {
        String url="http://music.baidu.com/top/dayhot";
        Map<String,Object> res=new HashMap<>();
        BaiduMusicUtil baiduMusicUtil=new BaiduMusicUtil(url);

        String html=baiduMusicUtil.getHtml();
        System.out.println(html);
        Document doc = Jsoup.parse(html);
        Elements resultLinks =doc.select(".song-title a");
        List<MusicModel> musicModelList=new ArrayList<>();

        for (Element element:resultLinks){
            MusicModel musicModel=new MusicModel();
            musicModel.setTitle(element.attr("title"));
            musicModel.setUrl(element.attr("href"));
            musicModelList.add(musicModel);
        }
        res.put("musicModelList",musicModelList);
        System.out.println(res);
    }
}
