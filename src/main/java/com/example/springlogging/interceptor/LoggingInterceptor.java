package com.example.springlogging.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response,
                             final Object handler) {
        // 핸들러 호출 직전에 로깅
        log(request, response, "Pre-handle");

        return true;
    }

    @Override
    public void postHandle(final HttpServletRequest request,
                           final HttpServletResponse response,
                           final Object handler,
                           final ModelAndView modelAndView) {
        // 핸들러 호출 이후에 로깅
        log(request, response, "Post-handle");
    }

    @Override
    public void afterCompletion(final HttpServletRequest request,
                                final HttpServletResponse response,
                                final Object handler,
                                final Exception ex) {
        // View를 렌더링 한 이후에 로깅
        log(request, response, "After Completion");
    }

    private void log(final HttpServletRequest request,
                     final HttpServletResponse response,
                     final String prefix) {
        final String queryString = (request.getQueryString() == null) ? ("") : ('?' + request.getQueryString());

        log.info(
                "[{}] {} - \"{} {} {}\" {}",
                prefix,
                request.getRemoteAddr(),
                request.getMethod(),
                request.getRequestURI() + queryString,
                request.getProtocol(),
                response.getStatus()
        );
    }

}
