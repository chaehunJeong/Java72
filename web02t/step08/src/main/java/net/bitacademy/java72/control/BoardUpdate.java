package net.bitacademy.java72.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java72.context.MyApplicationContext;
import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;

public class BoardUpdate extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    MyApplicationContext context = 
        MyApplicationContext.getInstance();
    
    BoardDao boardDao = (BoardDao)context.getBean("boardDao");
      
    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    board.setPassword(request.getParameter("password"));
    
    try {
      boardDao.update(board);
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/error");

      //ServletRequest에 전달할 객체를 저장한다.
      request.setAttribute("error", e);
      
      rd.forward(request, response);
      return;
    }
    response.sendRedirect("list.do");
  }

}
