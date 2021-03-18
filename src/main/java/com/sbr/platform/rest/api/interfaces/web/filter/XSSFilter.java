package com.sbr.platform.rest.api.interfaces.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class XSSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("XSSFilter : initiated");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        XSSRequestWrapper wrappedRequest = new XSSRequestWrapper((HttpServletRequest) request);

        String body = IOUtils.toString(wrappedRequest.getReader());
        if (!StringUtils.isBlank(body)) {
            body = XSSUtils.stripXSS(body);
            wrappedRequest.resetInputStream(body.getBytes());
        }
        chain.doFilter(wrappedRequest, response);
    }


    @Override
    public void destroy() {
        log.info("XSSFilter : destroy");
    }
}
