/*package com.eomcs.lms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.eomcs.lms.domain.Member;

index.html 안들어가지는 현상 고치기!







// '/'로 시작하는 모든 메서드가 동작하기전 실행한다.
@WebFilter("/*")
public class OldAuthFilter implements Filter {
 
  @Override
  public void doFilter(
      ServletRequest request,
      ServletResponse response,
      FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpReq = (HttpServletRequest) request;
    HttpServletResponse httpResp = (HttpServletResponse) response;
    String servletPath = httpReq.getServletPath();
    
        //서블릿 패스가 /auth가 아니라면 검사!
    if(!servletPath.startsWith("/auth") && 
        !servletPath.startsWith(".html") &&
        !servletPath.startsWith(".css") &&
        !servletPath.startsWith(".js") &&
        !servletPath.startsWith(".png") &&
        !servletPath.startsWith(".jpeg")) {
      HttpSession session = httpReq.getSession();
      Member loginUser = (Member) session.getAttribute("loginUser");
      if(loginUser == null) {
         httpResp.sendRedirect("/auth/login");
         return;
      }
    }
    
    chain.doFilter(request, response);
    
  }
}
*/