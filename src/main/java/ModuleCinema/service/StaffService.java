package ModuleCinema.service;

import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Staff;

import java.util.List;

public interface StaffService {
    Result getPlaysService(Staff staff, int page);

    Result updatePlayState(int playId, int playState);
}
