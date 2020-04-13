package ModuleCinema.service;

import ModuleCinema.pojo.Result;

public interface UserService {
    Result getHotPlay(int page);

    Result getPlayByName(String playName);

    Result getShow(int playId, int day);

    Result getPlayByPlayId(int playId);
}
