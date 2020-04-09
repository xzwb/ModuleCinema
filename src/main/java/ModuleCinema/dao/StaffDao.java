package ModuleCinema.dao;

import ModuleCinema.pojo.Play;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDao {
    /**
     * 获取所有的电影
     * @param page
     * @return
     */
    List<Play> getPlays(@Param("page") int page);

    /**
     * 获取电影总数
     * @return
     */
    int getTotal();

    void updatePlayState(@Param("playId") int playId,
                         @Param("playState") int playState);

    /**
     * 添加影片信息
     * @param play
     */
    void insertPlay(Play play);
}
