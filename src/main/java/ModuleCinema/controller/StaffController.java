package ModuleCinema.controller;

import ModuleCinema.pojo.Play;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Staff;
import ModuleCinema.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

@Controller
@CrossOrigin(allowCredentials = "true")
public class StaffController {
    @Autowired
    StaffService staffService;

    @GetMapping("/s/home")
    @ResponseBody
    public Result staffHome(HttpSession session) {
        Staff staff = (Staff) session.getAttribute("staff");
        return staffService.getStaffHome(staff);
    }

    @GetMapping("/s/play/{page}")
    @ResponseBody
    public Result getPlays(@PathVariable("page") int page) {
        return staffService.getPlays(page);
    }

    @PostMapping("/s/playState/{playId}")
    @ResponseBody
    public Result setPlayState(@PathVariable("playId") int playId,
                               @RequestBody Map<String, Integer> playState) {
        return staffService.setPlayState(playId, playState.get("playState"));
    }

    @PostMapping("/s/insert/play")
    @ResponseBody
    public Result insertPlay(Play play,
                             @RequestPart("file") Part part,
                             HttpSession session) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String src = session.getServletContext().getRealPath("/");
        String  playSrcFile = timeInMillis + part.getSubmittedFileName();
        if (!"".equals(part.getSubmittedFileName())) {
            play.setPlaySrcFile(playSrcFile);
            try {
                part.write(src + playSrcFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return staffService.insertPlay(play);
    }
}
