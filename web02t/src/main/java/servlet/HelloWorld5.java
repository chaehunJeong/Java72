package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorld5 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      ServletRequest request, 
      ServletResponse response) throws ServletException, IOException {
    // 웹 브라우저가 보낸 데이터 읽기
    // GET 방식
    // http://localhost:9999/web02t/hello5?name=값&age=값
    // POST 방식 <= 나중에 설명
    String name = request.getParameter("name");
    int age = Integer.parseInt(
        request.getParameter("age"));
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    // 웹 브라우저로 출력하기
    out.printf("%s(%d)\n", name, age);
    
  }

}






