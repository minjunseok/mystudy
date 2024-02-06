package bitcamp.myapp.handler;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.util.Prompt;
import java.util.Scanner;

public class HelpHandler extends AbstractMenuHandler {

  Scanner sc = new Scanner(System.in);

  public HelpHandler(Prompt prompt) {
    super(prompt);
  }

  @Override
  protected void action() {

    System.out.println("동아리 이용 도움말( ⁎ ᵕᴗᵕ ⁎ )");
    while (true) {

      System.out.println("1. 이용방법");
      System.out.println("2. 필독사항");
      System.out.println("3. 고객센터");
      System.out.println("4. 이전메뉴");
      System.out.print("원하는 메뉴를 선택해주세요 (▰˘◡˘▰)");

      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          System.out.print("*동아리 이용방법* \n"
               +"만나면 서로 밝게 인사하세요\n"
                +"기본적인 매너를 지켜주세요\n"
                + "동아리 목적에 맞게 활동해주세요\n" );
          sc.nextLine();  // 버퍼 비우기
          break;

        case 2:
         System.out.print("*동아리 이용간 필독사항*"
             + "1년간 활동이 없을시 휴면회원으로 전환됩니다\n"
              + "불량회원은 동아리 이용이 정지될 수 있습니다\n"
                  + "다같이 쓰는 동아리 게시판은 올바르게 사용해주세요\n");

          break;

        case 3:
          System.out.println("고객센터 번호는 XXX-XXX-XXXX입니다");
        break;

        case 4:
          return;

        default:
          System.out.println("잘못된 선택입니다. 다시 선택하세요.");
          break;
      }
    }
  }
}

