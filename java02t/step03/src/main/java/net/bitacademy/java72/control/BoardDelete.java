package net.bitacademy.java72.control;

import java.util.Map;
import java.util.Scanner;

import net.bitacademy.java72.annotation.Autowired;
import net.bitacademy.java72.annotation.Controller;
import net.bitacademy.java72.annotation.RequestMapping;
import net.bitacademy.java72.dao.BoardDao;

@Controller("board/delete.do")
public class BoardDelete {
  BoardDao boardDao;
  
  @Autowired
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @RequestMapping
  public void delete(Map<String, Object> paramMap) {
    Scanner scanner = (Scanner)paramMap.get("inputScanner");
    System.out.print("삭제할 게시물 번호? ");
    int no = Integer.parseInt(scanner.nextLine());
    
    boardDao.delete(no);
    
  }

}
