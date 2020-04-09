package ModuleCinema.interceptor;

import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * session拦截器
 */
public class UserSessionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
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
