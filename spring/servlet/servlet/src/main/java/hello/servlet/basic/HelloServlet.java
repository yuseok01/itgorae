package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//1.HttpServlet 상속받기
//2.webServlet 어노테이션 적기
//3. ctrl o ->  service 넣기 -> 그러면 서비스 메서드 호출이됨
//4. 쿼리스트링 파라미터 읽기
@WebServlet(name = "helloServlet" , urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        extracted(request, response);
    }

    private static void extracted(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        //?username = kim 쿼리파라미터
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
    }

}
