package com.alamin.InterceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component //Then register to the WebMvcConfigurable
@Slf4j
public class SimpleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        return HandlerInterceptor.super.preHandle(request, response, handler);
//        return false or true;
        // Multiples-Interceptor used to internal communications of the 'request.setAttribute()'
        long sTime = System.currentTimeMillis();
        request.setAttribute("sTime", sTime);
//        if (request.getRemoteAddr().equals("127.0.0.1")) {
//            response.getWriter().println("access denied");
//            response.getWriter().flush();
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (long) request.getAttribute("sTime");
        long endTime =System.currentTimeMillis();
        log.info("Interceptor execution time: {} ms", endTime - startTime);
    }
}
