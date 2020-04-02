package ModuleCinema.service;

import ModuleCinema.pojo.Boss;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.User;

public interface HomeService {
    Result homeService(User user);

    Result homeServiceBoss(Boss boss, int page);
}
