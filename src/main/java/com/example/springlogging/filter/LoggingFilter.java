package com.example.springlogging.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(final HttpServletRequest request,
                                    final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {
        // 요청을 받는 시점에 로깅
        log(request, response, "Pre-filter");

        filterChain.doFilter(request, response);

        // 응답을 반환하는 시점에 로깅
        log(request, response, "Post-filter");
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
