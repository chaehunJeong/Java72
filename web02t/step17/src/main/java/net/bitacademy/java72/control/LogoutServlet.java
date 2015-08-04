package net.bitacademy.java72.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import net.bitacademy.java72.annotation.RequestMapping;

@Controller("/auth/logout.do")
public class LogoutServlet {
  
  @RequestMapping
  public String logout(
      HttpServletRequest request, 
      HttpServletResponse response) {
    
    HttpSession session = request.getSession();
    session.invalidate(); 
    
    return "redirect:login.do";
  }

}







