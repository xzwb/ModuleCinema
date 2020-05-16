package ModuleCinema.dao;

import ModuleCinema.pojo.Play;
import ModuleCinema.pojo.Set;
import ModuleCinema.pojo.Show;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserDao {
    /**
     * 用户获取热门影片
     */
    List<Play> userGetHotPlay(@Param("page") int page);

    /**
     * 用户获取热门影片总数
     */
    int getHotPlayTotal();

    /**
     * 查询by电影名字
     * @param playName
     * @return
     */
    List<Play> selectByPlayName(@Param("playName") String playName);

    List<Show> selectShow(@Param("date") String date,
                          @Param("playId") int PlayId);

    Play selectByPlayId(@Param("playId") int playId);

    List<Set> getSet(@Param("showId") int showId);

    void buy(@Param("showId") int showId,
             @Param("row") int row,
             @Param("col") int col,
             @Param("userId") int userId);

    List<Show> selectShowToday(@Param("date") String date,
                               @Param("playId") int playId,
                               @Param("startTime") String startTime);

    int selectOrderId(@Param("showId") int showId,
                      @Param("row") int row,
                      @Param("col") int col,
                      @Param("userId") int userId);
}
