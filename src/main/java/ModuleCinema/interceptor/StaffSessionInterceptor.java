package ModuleCinema.interceptor;

import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Staff;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 员工session
 */
public class StaffSessionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Staff staff = (Staff) request.getSession().getAttribute("staff");
        if (staff == null) {
            response.setContentType("application/json;charset=UTF-8");
            Result result = new Result();
            result.setState(-1);
            result.setMessage("长时间未操作");
            response.getWriter().write(result.toString());
            return false;
        }
        return true;
    }
}
