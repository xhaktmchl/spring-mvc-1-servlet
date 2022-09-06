package hello.springmvc1servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //[status-line] 상태코드 설정
        response.setStatus(HttpServletResponse.SC_OK); //200

        //[response-headers] 헤더 설정
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, mustrevalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header","hello");

        //[Header 편의 메서드]
        content(response);
        cookie(response);
        redirect(response);

        //[message body] body 설정
        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }

    private void content(HttpServletResponse response) {
        // 설정 하려는 값
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2

        /*
        헤더 컨텐트 설정 방법1
         */
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");

        // 헤더 컨텐트 설정 방법 2
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)
    }

    // 쿠키 편의 메서드
    private void cookie(HttpServletResponse response) {

        // 설정 하려는 값
        //Set-Cookie: myCookie=good; Max-Age=600;

        //쿠키 설정 방법 1
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");

        // 쿠키설정 방법 2
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    // 리다이렉션 설정
    private void redirect(HttpServletResponse response) throws IOException {
        // 설정 하려는 값
        //Status Code 302
        //Location: /basic/hello-form.html

        // 리다리엑션 설정 방법1
        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html");

        // 리다리엑션 설정 방법 2
        response.sendRedirect("/basic/hello-form.html");
    }
}
