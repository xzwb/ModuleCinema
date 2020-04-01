package ModuleCinema.service.impl;

import ModuleCinema.dao.HomeDao;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.User;
import ModuleCinema.pojo.UserAndHotPlay;
import ModuleCinema.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    HomeDao homeDao;

    @Override
    public Result homeService(User user) {
        Result result = new Result();
        UserAndHotPlay userAndHotPlay = new UserAndHotPlay();
        userAndHotPlay.setPlays(homeDao.homeDao());
        userAndHotPlay.setUser(user);
        result.setState(200);
        result.setMessage("成功查找");
        result.setData(userAndHotPlay);
        return result;
    }
}
