package cn.lucode.onlinemusic.utils.cache;

import cn.lucode.onlinemusic.utils.enums.RedisKey;
import cn.lucode.onlinemusic.utils.model.MusicModel;
import cn.lucode.redis.service.IRedisOperation;
import cn.lucode.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yunfeng.lu on 2017/10/4.
 */
@Component
public class SongCacheUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(SongCacheUtil.class);

    @Autowired
    private IRedisOperation redisOperation;

    public static final Long TIME_OUT_DAY = 24 * 60 * 60L;

    public void saveModel(MusicModel musicModel){
        redisOperation.setValue(RedisKey.KEY_BAIDU.getCode()
                        + "_" + musicModel.getId(),
                JsonUtil.obj2Json(musicModel),  TIME_OUT_DAY);

    }
}
