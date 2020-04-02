package ModuleCinema.controller;

import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Staff;
import ModuleCinema.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

@Controller
@CrossOrigin
public class BossController {
    @Autowired
    BossService bossService;

    @PostMapping("/b/post/delete/{staffId}")
    @ResponseBody
    public Result deleteStaff(@PathVariable("staffId") int staffId) {
        return bossService.deleteService(staffId);
    }

    @PostMapping("/b/post/update/{staffId}")
    @ResponseBody
    public Result updateStaff(@PathVariable("staffId") int staffId,
                              @RequestBody Map<String, String> staffGrade) {
        return bossService.updateService(staffId, staffGrade.get("staffGrade"));
    }

    @PostMapping("/b/post/insert")
    @ResponseBody
    public Result insertStaff(@RequestBody Staff staff, @RequestPart("staffAvatar") Part part, HttpSession session) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String staffAvatar = session.getServletContext().getRealPath("/") +
                timeInMillis + part.getSubmittedFileName();
        if (!"".equals(part.getSubmittedFileName())) {
            staff.setStaffAvatar(staffAvatar);
            try {
                part.write(staffAvatar);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bossService.insertService(staff);
    }
}
