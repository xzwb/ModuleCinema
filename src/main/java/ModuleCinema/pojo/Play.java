package ModuleCinema.pojo;

/**
 * 电影的基本信息
 */
public class Play {
    // 电影的id号
    private int playId;
    // 电影的名字
    private String playName;
    // 电影的状态
    private int playState;
    // 电影的简介
    private String playIntroduction;
    // 电影的时长
    private int playDuration;
    // 电影的海报图片文件
    private String playSrcFile;

    public String getPlaySrcFile() {
        return playSrcFile;
    }

    public void setPlaySrcFile(String playSrcFile) {
        this.playSrcFile = playSrcFile;
    }

    public int getPlayId() {
        return playId;
    }

    public void setPlayId(int playId) {
        this.playId = playId;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public int getPlayState() {
        return playState;
    }

    public void setPlayState(int playState) {
        this.playState = playState;
    }

    public String getPlayIntroduction() {
        return playIntroduction;
    }

    public void setPlayIntroduction(String playIntroduction) {
        this.playIntroduction = playIntroduction;
    }

    public int getPlayDuration() {
        return playDuration;
    }

    public void setPlayDuration(int playDuration) {
        this.playDuration = playDuration;
    }
}
