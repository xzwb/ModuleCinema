package ModuleCinema.controller;

import ModuleCinema.pojo.*;
import ModuleCinema.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.text.ParseException;
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

    @PostMapping("/s/insert/show")
    @ResponseBody
    public Result insertShow(@RequestParam("price") String price,
                             @RequestParam("showTing") String showTing,
                             @RequestParam("playId") String playId,
                             @RequestParam("startTime") String startTime,
                             @RequestParam("showDate") String showDate) throws ParseException {
//    public Result insertShow(Show1 show1) {
        Show1 show1 = new Show1();
        show1.setPrice(price);

        show1.setShowTing(showTing);
        show1.setPlayId(playId);
        show1.setStartTime(startTime);
        show1.setShowDate(showDate);
        System.out.println(show1);
        Show show = new Show();
        show.setPlayId(show1.getPlayId());
        show.setPrice(show1.getPrice());
        show.setShowDate(show1.getShowDate());
        show.setShowTing(show1.getShowTing());
        show.setStartTime(show1.getStartTime());
        return staffService.insertShow(show);
    }

    @GetMapping("/s/get/show/{page}")
    @ResponseBody
    public Result getShows(@PathVariable("page") int page) {
        return staffService.getShow(page);
    }

    @PostMapping("/s/delete/{showId}")
    @ResponseBody
    public Result deleteShow(@PathVariable("showId") int showId) {
        return staffService.deleteShow(showId);
    }
}
