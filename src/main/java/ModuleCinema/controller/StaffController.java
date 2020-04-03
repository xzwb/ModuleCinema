package ModuleCinema.controller;

import ModuleCinema.pojo.Play;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Staff;
import ModuleCinema.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@CrossOrigin
public class StaffController {
    @Autowired
    StaffService staffService;

    @GetMapping("/s/get/plays/{page}")
    @ResponseBody
    public Result getPlays(HttpSession session, @PathVariable("page") int page) {
        Staff staff = (Staff) session.getAttribute("staff");
        return staffService.getPlaysService(staff, page);
    }

    @PostMapping("/s/post/update/{playId}")
    @ResponseBody
    public Result updatePlayState(@PathVariable("playId") int playId,
                                  @RequestBody Map<String, Integer> playState) {
        return staffService.updatePlayState(playId, playState.get("playState"));
    }

}
