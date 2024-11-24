package pzn.belajarspringwebmvc.controller;

//make dedicated error page

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//must be implement ErrorController
public class ErrorPageController implements ErrorController {

    @RequestMapping(path = "/error")
    //using HttpServletRequest to look the error
    public ResponseEntity<String> error(HttpServletRequest request) {
        //using RequestDispatcher to get what error that we need
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        String html = """
                <html>
                <body>
                <h1>$status - $message</h1>
                </body>
                </html>
                """.replace("$status", statusCode.toString()).replace("$message", message);

        return ResponseEntity.status(statusCode).body(html);
    }
}
