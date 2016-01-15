import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import jp.pecolly.core.web.http.BufferedHttpServletRequestWrapper;

/**
 * Created by ryu_shozen on 2016/01/15.
 */
public class RequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request = new BufferedHttpServletRequestWrapper((HttpServletRequest) request);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}