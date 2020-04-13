package ModuleCinema.controller;

import ModuleCinema.pojo.Result;
import ModuleCinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping("/u/search/play")
    @ResponseBody
    public Result searchPlay(@RequestBody Map<String, String> playName) {
        return userService.getPlayByName(playName.get("playName"));
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
}
