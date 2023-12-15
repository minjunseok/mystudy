package bitcamp.myapp.menu;

import bitcamp.util.Prompt;

// Composite 패턴에서 leaf 역할을 수행하는 클래스
// Leaf?
// - 하위 항목을 포함하지 않는 말단 객체
// - 예를들어 파일시스템에서 '파일'에 해당한다.
//
public class MenuItem implements Menu {

    String title;

    public MenuItem(String title) { //제목만 설정하는 메뉴아이템
        this.title = title;
    }

    public MenuItem(String title , MenuHandler menuHandler) {

        this(title);
        this.menuHandler = menuHandler;
    }

    public void execute(Prompt prompt) { //메뉴핸들러가 등록되어있으면 실행하겠다.
        if (this.menuHandler != null) {
            this.menuHandler.action();
        }
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}
