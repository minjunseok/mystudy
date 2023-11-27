package bitcamp.myapp;

public class App {

  public static void main(String[] args) {
//변수를 사용함으로써 메모리 사용
    //실행속도가 상대적으로 떨어질 수 있으나 코드를 직관적으로 이해가 가능 refactoring의 목적중 하나
    //refactoring = 만든코드를 다시 정리함
    //반댓말은 optimizing = 개발비절감을 포기하고 성능을 강화한다. (현재는 컴퓨터성능강화로 중요하지않음)
    //유지보수가 빨라짐= 개발비 절감

    String ANSI_CLEAR = "\033[0m";
    String ANSI_BOLD_RED = "\033[1;31m";
    String ANSI_RED = "\033[0;31m";
    String appTitle = "[과제관리 시스템]";

    String menu1 = "1. 과제 ",
        menu2 = "2. 게시글",
        menu3 = "3. 도움말",
        menu4 = "4. 종료";

    System.out.println(ANSI_BOLD_RED + appTitle + ANSI_CLEAR);
    System.out.println();
    System.out.println(menu1);
    System.out.println(menu2);
    System.out.println(menu3);
    System.out.println(menu4);
    System.out.println(ANSI_BOLD_RED + menu4 + ANSI_CLEAR);
  }
}