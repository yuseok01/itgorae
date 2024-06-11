package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/*

클라이언트가 서버로 보내는 방식
1 get 방식 쿼리파라미터
파라미터 전송기능
복수 파라미터(이름은 하나 값이 두개 -> getParmeterValues)
 단일 파라미터 가능

 2. post 방식 form
회원가입 상품 주문 등에서 사용
걍 post방식으로 보내면됨

 3.api 방식
 http message body에 데이터 담아서(자주쓰는 방식)
 */
@WebServlet(name = "RequestParamServlet", urlPatterns = "/request-param")

public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "= " + request.getParameter(paramName)));
        //모든 리퀘스트를 꺼내볼수있음
        //paramName은 key = getParameter(paramName)은 값
        System.out.println();
        //단일 조회
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("[전체 파라미터 조회] - end");
    }
}
