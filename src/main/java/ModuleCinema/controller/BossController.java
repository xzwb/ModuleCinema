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
@CrossOrigin(allowCredentials = "true")
public class BossController {
    @Autowired
    BossService bossService;

    @PostMapping("/b/post/delete/{staffId}")
    @ResponseBody
    public Result deleteStaff(@PathVariable("staffId") int staffId, HttpSession session) {
        String src = session.getServletContext().getRealPath("/");
        return bossService.deleteService(staffId, src);
    }

    @PostMapping("/b/post/update/{staffId}")
//    @PostMapping("/b/post/update")
    @ResponseBody
    public Result updateStaff(@PathVariable("staffId") int staffId,
                              @RequestBody(required = false) Map<String, String> staffGrade) {
//    public Result updateStaff(@RequestBody Staff staff) {
//        return bossService.updateService(staff.getStaffId(), staff.getStaffGrade());
        return bossService.updateService(staffId, staffGrade.get("staffGrade"));
    }

    @PostMapping("/b/post/insert")
    @ResponseBody
//    public Result insertStaff(@RequestParam String staffName,
//                              @RequestParam String staffGrade,
//                              @RequestParam String staffPassword,
//                              @RequestPart("file") Part part,
//                              HttpSession session) {
    public Result insertStaff(Staff staff,
                              @RequestPart("file") Part part,
                              HttpSession session) {
//        Staff staff = new Staff();
//        staff.setStaffGrade(staffGrade);
//        staff.setStaffName(staffName);
//        staff.setStaffPassword(staffPassword);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        String src = session.getServletContext().getRealPath("/");
        String staffAvatar = timeInMillis + part.getSubmittedFileName();
        if (!"".equals(part.getSubmittedFileName())) {
            staff.setStaffAvatar(staffAvatar);
            try {
                part.write(src + staffAvatar);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bossService.insertService(staff);
    }
}
