package bitcamp.app1;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c03_1")
public class Controller03_1 {
    // 테스트 방법:
    // => http://localhost:9999/eomcs-spring-webmvc/app1/c03_1?name=kim
    @GetMapping(params = "name")
    @ResponseBody
    public String handler1() {
      return "handler1";
    }


  // 테스트 방법:
  // => http://localhost:9999/eomcs-spring-webmvc/app1/c03_1?age=20
  @GetMapping(params = "age")
  @ResponseBody
  public String handler2() {
    return "handler2";
  }

  // 테스트 방법: 해당 파라미터가 둘다 있는 경우만 실행하라
  // => http://localhost:9999/eomcs-spring-webmvc/app1/c03_1?name=kim&age=20
  @GetMapping(params = {"age", "name"})
  @ResponseBody
  public String handler3() {
    return "handler3";
  }


  // 테스트 방법: else 값이 없거나 엉뚱한 요청을 했거나 등등 그밖의 경우를 처리(GET요청)
  // => http://localhost:9999/eomcs-spring-webmvc/app1/c03_1
  @GetMapping
  @ResponseBody
  public String handler4() {
    return "handler4";
  }

  }
