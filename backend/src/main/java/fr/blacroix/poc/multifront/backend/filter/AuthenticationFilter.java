package fr.blacroix.poc.multifront.backend.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Order(1)
@Component
@RequiredArgsConstructor
public class AuthenticationFilter implements Filter {

    @Value("${api-key}")
    private String apiKey;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (request instanceof HttpServletRequest httpRequest) {
            String givenApiKey = httpRequest.getHeader("X-API-KEY");
            log.info("Checking api-key with: {'{}', '{}'}", apiKey, httpRequest.getRequestURI());
            if (!apiKey.equals(givenApiKey)) {
                throw new RuntimeException("Api-key is not valid");
            }
        } else {
            throw new UnsupportedOperationException("Request is not a HttpServletRequest instance");
        }
        chain.doFilter(request, response);
    }

}
