package hello.springmvc1servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc1servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Content-Type 설정: application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        // java 객체 생성
        HelloData data = new HelloData();
        data.setUsername("kim");
        data.setAge(20);

        // 자바 객체를 json 값으로 String으로 저장
        // {"username":"kim","age":20}
        String result = objectMapper.writeValueAsString(data);

        response.getWriter().write(result);
    }
}
