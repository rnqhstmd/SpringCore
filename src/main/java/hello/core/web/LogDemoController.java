package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor//게터 세터 메서드 자동 생성
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")// /log-demo라는 경로로 들어오는 HTTP요청을 처리하는 메서드에 부여
    @ResponseBody //컨트롤러의 메서드가 HTTP응답의 본문을 직접 생성하고, 해당 데이터를 응답으로 반환함을 알려줌
    public String logDemo(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString();

        myLogger.setRequestURL(requestURL);
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "ok";
    }
}
