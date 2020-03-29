package ModuleCinema.pojo;

public class Result {
    // 返回的状态码
    private int state;
    // 返回的信息
    private String message;
    // 返回的具体内容
    private Object data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
