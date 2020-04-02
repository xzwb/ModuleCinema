package ModuleCinema.interceptor;

import ModuleCinema.pojo.Boss;
import ModuleCinema.pojo.Result;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 经理session拦截器
 */
public class BossSessionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Boss boss = (Boss) request.getSession().getAttribute("boss");
        if (boss == null) {
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
