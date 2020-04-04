package ModuleCinema.service;

import ModuleCinema.pojo.Boss;
import ModuleCinema.pojo.Result;

public interface HomeService {
    Result homeServiceBoss(Boss boss);

    Result getStaffs(int page);
}
