package ModuleCinema.dao;

import ModuleCinema.pojo.Play;
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
}
