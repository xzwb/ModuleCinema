package ModuleCinema.dao;

import ModuleCinema.pojo.Play;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDao {
    List<Play> getPlays(@Param("page") int page);

    int getPlayTotal();

    void updatePlayState(@Param("playId") int playId, @Param("playState") int playState);
}
