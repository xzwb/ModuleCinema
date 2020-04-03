package ModuleCinema.service.impl;

import ModuleCinema.dao.StaffDao;
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
    public Result updatePlayState(int playId, int playState) {
        Result result = new Result();
        result.setState(200);
        result.setMessage("成功修改");
        staffDao.updatePlayState(playId, playState);
        return result;
    }

    @Override
    public Result getPlaysService(Staff staff, int page) {
        int total = staffDao.getPlayTotal();
        Result result = new Result();
        result.setState(total);
        page = (page - 1) * 10;
        staff.setPlays(staffDao.getPlays(page));
        result.setMessage("查询成功");
        result.setData(staff);
        return result;
    }
}
