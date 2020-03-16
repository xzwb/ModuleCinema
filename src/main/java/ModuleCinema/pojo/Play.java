package ModuleCinema.pojo;

import java.util.List;

/**
 * 演出剧目表
 */
public class Play {
    // 剧目的编号唯一标识
    private int playId;
    // 剧目名称
    private String playName;
    // 剧目状态 (已下映, 正在热播, 即将上映)
    private int playStatus;
    // 剧目时长
    private String playDuration;
    // 剧目类型
    private String playType;
    // 剧目简介
    private String playIntroduction;
}
