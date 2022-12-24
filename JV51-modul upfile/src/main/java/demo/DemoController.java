package demo;
import java.io.File;
import java.nio.file.Path;

import entity.MyFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class DemoController {
//
@RequestMapping("/")
public String index(Model model) {
    model.addAttribute("myFile", new MyFile());

    return "index";
}

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(MyFile myFile, Model model) {
        model.addAttribute("message", "upload success");
        model.addAttribute("description", myFile.getDescription());

        try {
            MultipartFile multipartFile = myFile.getMultipartFile();
            String fileName = multipartFile.getOriginalFilename();
            File file = new File("C:/Users/PC/Downloads/JV51_SpringSecurity/JV51_SpringSecurity/src/main/webapp/image", fileName);
            System.out.println(file);
            multipartFile.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "upload failed");
        }
        myFile.setImageUrl(""+ new File("C:/Users/PC/Downloads/JV51_SpringSecurity/JV51_SpringSecurity/src/main/webapp/image", myFile.getMultipartFile().getOriginalFilename()));
        System.out.println(myFile.getImageUrl());
        model.addAttribute("MyFile", myFile);
        return "result";
    }

}
