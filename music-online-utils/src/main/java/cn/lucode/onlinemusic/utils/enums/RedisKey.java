package cn.lucode.onlinemusic.utils.enums;

/**
 * Created by yunfeng.lu on 2017/10/6.
 */
public enum RedisKey {
    KEY_BAIDU("KEY_BAIDU");

    /**
     * 代码
     */
    private String code;

    /**
     * @param code
     */
    private RedisKey(String code) {
        this.code = code;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     *
     * @param code
     * @return
     */
    public static RedisKey getByCode(String code) {
        for (RedisKey param : values()) {
            if (param.getCode().equals(code)) {
                return param;
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

}
