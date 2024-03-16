package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 이 애노테이션을 붙인다.
@RequestMapping("/c01_1") // 컨트롤러에 URL 매핑
public class Controller01_1 {


  //RequestHandler
  //@RequestMapping //이 애노테이션을 붙이면 요청이 들어왔을 때 호출될 메서드임을 표시한다.
  @ResponseBody //이걸 붙여야지 프론트 콘트롤러에게 말하는 것이다 이거 그대로 클라이언트 리턴해
  public String handler() {
    return "c01_1 -> handler()";
  }

@RequestMapping
@ResponseBody
public String handler2() {
return "c01_1 -> handler2()";
}




}