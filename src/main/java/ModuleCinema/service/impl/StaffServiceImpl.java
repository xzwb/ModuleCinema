package ModuleCinema.service.impl;

import ModuleCinema.dao.StaffDao;
import ModuleCinema.pojo.Play;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Staff;
import ModuleCinema.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffDao staffDao;

    @Override
    public Result getStaffHome(Staff staff) {
        Result result = new Result();
        result.setState(200);
        result.setMessage("成功来到主页");
        result.setData(staff);
        return result;
    }

    @Override
    public Result getPlays(int page) {
        page = (page - 1) * 6;
        Result result = new Result();
        result.setState(staffDao.getTotal());
        result.setMessage("成功");
        result.setData(staffDao.getPlays(page));
        return result;
    }

    @Override
    public Result setPlayState(int playId, int playState) {
        Result result = new Result();
        staffDao.updatePlayState(playId, playState);
        result.setState(200);
        result.setMessage("成功修改" + playId + "的状态");
        return result;
    }

    @Override
    public Result insertPlay(Play play) {
        Result result = new Result();
        staffDao.insertPlay(play);
        result.setState(200);
        result.setMessage("成功添加");
        result.setData(play.getPlayId());
        return result;
    }
}
