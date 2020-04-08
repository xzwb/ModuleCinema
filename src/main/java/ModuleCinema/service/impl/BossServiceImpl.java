package ModuleCinema.service.impl;

import ModuleCinema.dao.BossDao;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Staff;
import ModuleCinema.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class BossServiceImpl implements BossService {
    @Autowired
    BossDao bossDao;

    @Override
    public Result updateService(int staffId, String staffGrade) {
        Result result = new Result();
        bossDao.updateStaff(staffId, staffGrade);
        result.setState(200);
        result.setMessage("成功修改");
        return result;
    }

    @Override
    public Result deleteService(int staffId, String src) {
        Result result = new Result();
        src = src + bossDao.getStaffAvatar(staffId);
        File file = new File(src);
        file.delete();
        bossDao.deleteStaff(staffId);
        result.setState(200);
        result.setMessage("成功删除编号为"+staffId+"的员工");
        return result;
    }

    @Override
    public Result insertService(Staff staff) {
        Result result = new Result();
        bossDao.insertStaff(staff);
        if (staff.getStaffId() == 0) {
            result.setState(400);
            result.setMessage("添加失败");
            return result;
        }
        result.setState(200);
        result.setMessage("添加成功");
        result.setData(staff);
        return result;
    }
}
