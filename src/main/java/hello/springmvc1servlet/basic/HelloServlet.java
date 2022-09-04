package hello.springmvc1servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
name: 서블릿 이름
urlPatterns: URL 매핑
 */
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.service(request, response);

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // res 객체 설정
        response.setContentType("text/plain"); // http header에 들어가는 정보들 설정
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username); // http res body에 값이 저장된다.
    }
}
