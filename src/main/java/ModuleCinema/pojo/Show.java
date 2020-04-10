package ModuleCinema.pojo;

import java.util.Date;

public class Show {
    private int showId;
    // 演出厅
    private int showTing;
    // 开始时间
    private String startTime;
    // 价格
    private float price;
    // 演出日期
    private Date showDate;
    private int playId;

    public int getPlayId() {
        return playId;
    }

    public void setPlayId(int playId) {
        this.playId = playId;
    }

    private Play play;

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getShowTing() {
        return showTing;
    }

    public void setShowTing(int showTing) {
        this.showTing = showTing;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }
}
