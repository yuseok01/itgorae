package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RequestBodyStringServlet", urlPatterns = "/request-body-string")

public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        //inputStream을 통해 바이트코드를 바로얻을수있따.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        //inputsteam을 스트링형식으로 바꾸기 , utf_8을 꼭 파라미터로 같이 넣어주기
        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");


        

    }
}
