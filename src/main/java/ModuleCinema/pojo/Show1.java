package ModuleCinema.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Show1 {
    private int showId;
    // 演出厅
    private Integer showTing;
    // 开始时间
    private String startTime;
    // 价格
    private float price;
    // 演出日期
    private Date showDate;
    private Integer playId;

    public void setShowTing(String showTing) {
        this.showTing = Integer.parseInt(showTing);
    }

    public void setPrice(String price) {
        this.price = Float.parseFloat(price);
    }

    public void setPlayId(String playId) {
        this.playId = Integer.parseInt(playId);
    }

    public void setShowDate(String showDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.showDate = simpleDateFormat.parse(showDate);;
    }

    public void setStartTime(String startTime) {
        System.out.println(startTime);
        this.startTime = startTime;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Integer getShowId() {
        return showId;
    }

    public Integer getShowTing() {
        return showTing;
    }

    public String getStartTime() {
        return startTime;
    }

    public float getPrice() {
        return price;
    }

    public Date getShowDate() {
        return showDate;
    }

    public int getPlayId() {
        return playId;
    }

    @Override
    public String toString() {
        return "Show1{" +
                "showId=" + showId +
                ", showTing=" + showTing +
                ", startTime='" + startTime + '\'' +
                ", price=" + price +
                ", showDate=" + showDate +
                ", playId=" + playId +
                '}';
    }
}
