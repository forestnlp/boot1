package com.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class TimerInterceptor implements HandlerInterceptor {

    private final ThreadLocal<LocalTime> threadLocalStart = new ThreadLocal<>();
    private final ThreadLocal<LocalTime> threadLocalEnd = new ThreadLocal<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LocalTime now = LocalTime.now();
        threadLocalStart.set(now);
        log.info("开始时间：{}",formatter.format(now));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LocalTime now = LocalTime.now();
        threadLocalEnd.set(now);
        log.info("结束时间：{}",formatter.format(now));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LocalTime start = threadLocalStart.get();
        LocalTime end = threadLocalEnd.get();
        log.info("耗时:{}毫秒", Duration.between(start,end).getNano()/1000000);
    }
}
