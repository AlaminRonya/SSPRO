package com.alamin.InterceptorDemo.interceptor;

import com.alamin.InterceptorDemo.model.RequestTracker;
import com.alamin.InterceptorDemo.repository.RequestRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class AnalyticsInterceptor implements HandlerInterceptor {
    @Autowired
    private RequestRepository repository;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final List<String> skipUrls = List.of(
            "/analytics/request-stat/**",
            "/dashboard/**"
    );
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
        if (modelAndView != null) {
            request.setAttribute("pageName", modelAndView.getViewName());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (skipUrls.stream().anyMatch(u-> u.startsWith(request.getRequestURI()))) {
            return;
        }
        long startTime = (long) request.getAttribute("sTime");
        String time = dateFormat.format(new Date(startTime));
        long endTime =System.currentTimeMillis();
        repository.addTracker(new RequestTracker(
                request.getRemoteAddr(),
                request.getMethod(),
                request.getRequestURI(),
                (String) request.getAttribute("pageName"),
                time,
                Thread.currentThread().getName(),
                endTime - startTime

        ));
        log.info("Interceptor execution time: {} ms", endTime - startTime);
    }
}
