package ModuleCinema.service;

import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Staff;

public interface BossService {
    Result deleteService(int staffId, String src);
    Result updateService(int staffId, String staffGrade);
    Result insertService(Staff staff);
}
