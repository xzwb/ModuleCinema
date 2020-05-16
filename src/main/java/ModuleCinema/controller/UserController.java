package ModuleCinema.controller;

import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Set;
import ModuleCinema.pojo.User;
import ModuleCinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@CrossOrigin(allowCredentials = "true")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 获取热门影片
     */
    @GetMapping("/u/hotPlay/{page}")
    @ResponseBody
    public Result getHotPlay(@PathVariable("page") int page) {
        return userService.getHotPlay(page);
    }

    @PostMapping("/u/search/play")
    @ResponseBody
    public Result searchPlay(String playName) {
        return userService.getPlayByName(playName);
    }

    /**
     * 用户查看当前影片的放映信息
     * @param playId
     * @param day   1表示今天 2表示明天 3表示后天
     * @return
     */
    @GetMapping("/u/show/{playId}/{day}")
    @ResponseBody
    public Result getShow(@PathVariable("playId") int playId,
                          @PathVariable("day")int day) {
        return userService.getShow(playId, day);
    }

    @GetMapping("/u/get/{playId}")
    @ResponseBody
    public Result getPlay(@PathVariable("playId") int playId) {
        return userService.getPlayByPlayId(playId);
    }

    @GetMapping("/u/choose/set/{showId}")
    @ResponseBody
    public Result getSet(@PathVariable("showId") int showId) {
        return userService.getSet(showId);
    }

    @PostMapping("/u/buy")
    @ResponseBody
    public Result buyTick(@RequestBody Set set, HttpSession session) {
        User user = (User) session.getAttribute("user");
        return userService.buy(set, user.getUserId());
    }
}
