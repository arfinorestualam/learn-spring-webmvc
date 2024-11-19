package pzn.belajarspringwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DateController {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

//    @GetMapping(path= "/date")
//    public void getDate(@RequestParam(name = "date")Date date,
//                        HttpServletResponse response) throws IOException {
//        response.getWriter().println("Date : " + dateFormat.format(date));
//    }

    //di rubah menggunakan annotation response body
    @GetMapping(path= "/date")
    @ResponseBody
    public String getDate(@RequestParam(name = "date")Date date) {
        return "Date : " + dateFormat.format(date);
    }
    //jika ingin mereturn sesuai dengan methodnya
}
