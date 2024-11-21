package pzn.belajarspringwebmvc.controller;

//example upload file

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@Controller
public class UploadController {

    @PostMapping(path = "/upload/profile",
            //khusus upload, consumesnya menggunakan yang dibawah
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ResponseBody
    public String upload(
            @RequestParam(name = "name") String name,
            //tambahkan multipart untuk request adanya file yang diupload
            @RequestParam(name = "profile") MultipartFile profile
    ) throws IOException {
        Path path = Path.of("upload/" + profile.getOriginalFilename());
        //Files.write(path, profile.getBytes()); -> ini manual
        //ini cara otomatis :
        profile.transferTo(path);
        return "Success save " + name + " to " + path;
    }
}
