package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c03_2")
public class Controller03_2 {

  @RequestMapping(method = RequestMethod.GET, headers = "name") // 헤더중에 name이라는 이름을 가졌으면 실행하라.
  @ResponseBody
  public String handler1() {
    return "handler1";
  }

  @RequestMapping(method = RequestMethod.GET, headers = "age") // 헤더중에 age라는 이름을 가졌으면 실행하라.
  @ResponseBody
  public String handler2() {
    return "handler2";
  }

  @RequestMapping(method = RequestMethod.GET, headers = {"age","name"}) // 헤더중에 age,name이라는 이름을 가졌으면 실행하라.
  @ResponseBody
  public String handler3() {
    return "handler3";
  }
  @GetMapping
  @ResponseBody
  public String handler4() {
    return "handler4";
  }
}
