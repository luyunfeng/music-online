package cn.lucode.onlinemusic.service.model;

import java.io.Serializable;

/**
 * Created by yunfeng.lu on 2017/10/3.
 */
public class MusicModel implements Serializable {
    private static final long serialVersionUID = 5140312147222188677L;
    private String title;
    private String url;
    private String songer;

    public String getSonger() {
        return songer;
    }

    public void setSonger(String songer) {
        this.songer = songer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MusicModel{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", songer='" + songer + '\'' +
                '}';
    }
}
