package ModuleCinema.service.impl;

import ModuleCinema.dao.UserDao;
import ModuleCinema.pojo.Result;
import ModuleCinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Result getPlayByName(String playName) {
        Result result = new Result();
        result.setState(200);
        result.setMessage("返回查询结果");
        result.setData(userDao.selectByPlayName(playName));
        return result;
    }

    @Override
    public Result getHotPlay(int page) {
        Result result = new Result();
        result.setState(userDao.getHotPlayTotal());
        result.setMessage("获取到正在热映和即将上线的电影");
        page = (page - 1) * 6;
        result.setData(userDao.userGetHotPlay(page));
        return result;
    }

    @Autowired
    UserDao userDao;
}
