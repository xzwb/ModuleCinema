package ModuleCinema.service;

import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Set;

public interface UserService {
    Result getHotPlay(int page);

    Result getPlayByName(String playName);

    Result getShow(int playId, int day);

    Result getPlayByPlayId(int playId);

    Result getSet(int showId);

    Result buy(Set set, int userId);
}
