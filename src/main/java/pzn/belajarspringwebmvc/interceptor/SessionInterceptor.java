package pzn.belajarspringwebmvc.interceptor;

//interceptor is like a middleware

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import pzn.belajarspringwebmvc.model.User;

@Component
//must implements HandlerInterceptor
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        //middleware to check if there is session stored or not
        //if not, redirect to login page
        if (user == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

}
