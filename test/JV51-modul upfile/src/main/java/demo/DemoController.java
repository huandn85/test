package demo;
import java.io.File;
import java.nio.file.Path;

import entity.MyFile;
import entity.UpFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import service.MService;
import service.MServiceImpl;


@Controller
public class DemoController {
    @Autowired
    private MServiceImpl mService;
//
@RequestMapping("/")
public String index(Model model) {
    model.addAttribute("myFile", new MyFile());

    return "index";
}

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(@RequestParam(name="name")String name, MultipartFile multipartFile, @ModelAttribute UpFile upFile, Model model) {
        model.addAttribute("message", "upload success");
        model.addAttribute("name",name);
        try {
            String fileName = multipartFile.getOriginalFilename();
            File file = new File("C:/Users/PC/Documents/test/test/JV51-modul upfile/src/main/webapp/resources/image", fileName);
            System.out.println(file);
            multipartFile.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "upload failed");
        }
        upFile.setImageUrl((""+ new File("", multipartFile.getOriginalFilename())).substring(1));
        System.out.println(upFile.getImageUrl());
        model.addAttribute("UpFile", upFile);
        upFile.setName(name);
        mService.saveImage(upFile);
        return "result";

    }

}
