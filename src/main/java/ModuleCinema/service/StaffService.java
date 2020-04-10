package ModuleCinema.service;

import ModuleCinema.pojo.Play;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Show;
import ModuleCinema.pojo.Staff;

public interface StaffService {
    /**
     * 或取用户主页
     * @param staff
     * @return
     */
    Result getStaffHome(Staff staff);

    /**
     * 获取所有的电影信息
     * @param page
     * @return
     */
    Result getPlays(int page);

    /**
     * 修改电影的状态
     * @param playId
     * @param playState
     * @return
     */
    Result setPlayState(int playId, int playState);

    /**
     * 添加电影信息
     * @param play
     * @return
     */
    Result insertPlay(Play play);

    /**
     * 添加演出信息
     * @param show
     * @return
     */
    Result insertShow(Show show);
}
