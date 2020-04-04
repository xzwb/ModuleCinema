package ModuleCinema.service.impl;

import ModuleCinema.dao.HomeDao;
import ModuleCinema.pojo.Boss;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.User;
import ModuleCinema.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    HomeDao homeDao;

    @Override
    public Result getStaffs(int page) {
        Result result = new Result();
        result.setState(200);
        page = (page - 1) * 6;
        result.setData(homeDao.selectStaff(page));
        result.setMessage("成功");
        return result;
    }

    @Override
    public Result homeServiceBoss(Boss boss) {
        Result result = new Result();
        result.setState(homeDao.staffTotal());
        result.setData(boss);
        result.setMessage("成功");
        return result;
    }

}
