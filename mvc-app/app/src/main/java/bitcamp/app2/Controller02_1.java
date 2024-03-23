package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c02_1")
public class Controller02_1 {

  // 테스트:
  //   http://localhost:9999/eomcs-spring-webmvc/app2/c02_1?name=kim&age=20
  @GetMapping
  @ResponseBody
  public String handler1(String name, int age) {

    return String.format("name=%s, age=%d", name, age);

  }

  // 테스트:
  //   http://localhost:9999/eomcs-spring-webmvc/app2/c02_1/kim/20
  @GetMapping("{name}/{age}")
  @ResponseBody
  public String handler2(
      /*
      @PathVariable("name") String name,
      @PathVariable("age") int age
       */
      // URL의 변수 이름을 생략하면 아규먼트 이름을 사용한다.
      @PathVariable String name,
      @PathVariable int age
  ) {

    return String.format("name=%s, age=%d", name, age);
  }

  // 테스트:
  //   http://localhost:9999/eomcs-spring-webmvc/app2/c02_1/kim_20
  @GetMapping("{name}_{age}")
  @ResponseBody
  public String handler3(
      @PathVariable String name,
      @PathVariable int age
  ) {
    return String.format("name=%s, age=%d", name, age);
  }
}
