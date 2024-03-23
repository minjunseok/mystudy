package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


  @Controller
  @RequestMapping("/c06_2")
  public class Controller06_2 {

    // 테스트:
    // http://.../app2/c06_2/error1
    @GetMapping("error1")
    public void error1() throws Exception {
      throw new Exception("request handler 오류 발생!");
    }

}
