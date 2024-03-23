package bitcamp.app2;


import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalControllerAdvice {

  @RequestMapping
  public ModelAndView error(HttpServletRequest request) {

    //서블릿 컨테이너가 서블릿을 실행하다가 예외가 발생하면
    //ServletRequest 보관소에 다음 이름으로 오류의 상태나 그 내용을 저장한다.
    //그 값을 꺼내서 JSP가 출력하면 된다.

    ModelAndView mv = new ModelAndView();

    mv.setViewName("error3");
    return mv;
  }

}
