package net.bitacademy.java72.step07.v07;

import java.util.Map;
import java.util.Scanner;

import net.bitacademy.java72.step07.v02.Board;
import net.bitacademy.java72.step07.v02.BoardDao;

@CommandProcessor("insert")
public class BoardInsert {

  BoardDao boardDao;
  
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @RequestMapping
  public void insert(Map<String, Object> paramMap) {
    Scanner scanner = (Scanner)paramMap.get("inputScanner");
    
    Board board = new Board();

    System.out.print("제목? ");
    board.setTitle(scanner.nextLine());

    System.out.print("내용? ");
    board.setContent(scanner.nextLine());

    System.out.print("암호? ");
    board.setPassword(scanner.nextLine());

    int count = boardDao.insert(board);
    if (count == 0) {
      System.out.println("입력 실패!");
    } else {
      System.out.println("입력 성공!");
    }
  }

}
