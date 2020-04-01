package ModuleCinema.dao;

import ModuleCinema.pojo.Play;
import ModuleCinema.pojo.UserAndHotPlay;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeDao {
    List<Play> homeDao();
}
