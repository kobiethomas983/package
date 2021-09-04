package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Optional;

@Slf4j
@Component
public class RequestLoggingConfig extends GenericFilterBean {
    private final static Logger LOGGER = LoggerFactory.getLogger(RequestLoggingConfig.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        final HttpServletRequest currentRequest = (HttpServletRequest) servletRequest;
        final HttpServletResponse currentResponse = (HttpServletResponse) servletResponse;

        MDC.put("http.host", currentRequest.getLocalName());
        MDC.put("hostAddress", InetAddress.getLocalHost().getHostAddress());
        MDC.put("http.method", currentRequest.getMethod());

        Optional.ofNullable(currentRequest.getHeader("user-agent"))
                .ifPresent(ua -> MDC.put("http.user_agent", ua));

        String query = (currentRequest.getQueryString() != null)?
                "?" + currentRequest.getQueryString() : "";
        String uri = currentRequest.getRequestURI()  + query;
        MDC.put("url", uri);

        try {
            filterChain.doFilter(currentRequest, servletResponse);
            String statusCode = String.valueOf(currentResponse.getStatus());
            MDC.put("status", statusCode);
            final StringBuilder logMessage = new StringBuilder(
                    "METHOD: ")
                    .append(currentRequest.getMethod())
                    .append(", URL: ").append(currentRequest.getRequestURL())
                    .append(", STATUS: ").append(statusCode);

            LOGGER.info(logMessage.toString());
        } catch (Throwable ex){
            LOGGER.error("Uncaught error with message: {} ", ex);
            throw ex;
        }
    }
}
