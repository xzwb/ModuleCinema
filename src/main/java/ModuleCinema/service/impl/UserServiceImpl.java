package ModuleCinema.service.impl;

import ModuleCinema.dao.UserDao;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Set;
import ModuleCinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    @Override
    public Result getPlayByPlayId(int playId) {
        Result result = new Result();
        result.setState(200);
        result.setMessage("查询电影的详细信息");
        result.setData(userDao.selectByPlayId(playId));
        return result;
    }

    @Override
    public Result getShow(int playId, int day) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = null;
        if (day == 1) {
            date = simpleDateFormat.format(new Date());
        } else if (day == 2) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE, 1);
            date = simpleDateFormat.format(calendar.getTime());
        } else if (day == 3) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE, 2);
            date = simpleDateFormat.format(calendar.getTime());
        }
        Result result = new Result();
        result.setState(200);
        result.setMessage("查看票务");
        result.setData(userDao.selectShow(date, playId));
        return result;
    }

    @Override
    public Result getSet(int showId) {
        Result result = new Result();
        result.setState(200);
        result.setMessage("成功");
        result.setData(userDao.getSet(showId));
        return result;
    }

    @Override
    public Result buy(Set set, int userId) {
        Result result = new Result();
        userDao.buy(set.getShowId(), set.getRow(), set.getCol(), userId);
        result.setState(200);
        result.setMessage("成功");
        return result;
    }

    @Autowired
    UserDao userDao;
}
