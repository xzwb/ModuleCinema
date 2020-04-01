package ModuleCinema.pojo;

import java.util.List;

public class UserAndHotPlay {
    private User user;
    private List<Play> plays;

    @Override
    public String toString() {
        return "UserAndHotPlay{" +
                "user=" + user +
                ", plays=" + plays +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Play> getPlays() {
        return plays;
    }

    public void setPlays(List<Play> plays) {
        this.plays = plays;
    }
}
