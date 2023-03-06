package controller;

import dto.FileResponseDto;
import entity.Category;
import entity.File;
import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.FileService;
import service.ProductService;

import java.io.IOException;
import java.util.*;


@Controller
//@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String up(){
        return "admin/TEST";
    }



//    @RequestMapping(value = "/*", method = RequestMethod.GET)
//    public String index(Model model) {
//        List<FileResponseDto> fileResponseDtos = new ArrayList<>();
//        List<File> files = fileService.getFiles();
//        files.forEach(file -> {
//            String fileUrl = ServletUriComponentsBuilder
//                    .fromCurrentContextPath()
//                    .path("/file/")
//                    .path(String.valueOf(file.getId()))
//                    .toUriString();
//
//            FileResponseDto fileResponseDto = new FileResponseDto();
//            fileResponseDto.setName(file.getName());
//            fileResponseDto.setUrl(fileUrl);
//
//            fileResponseDtos.add(fileResponseDto);
//        });
//
//        model.addAttribute("files", fileResponseDtos);
//
//        return "admin/image";
//    }
//@RequestMapping(value = "/requestProduct", method = RequestMethod.GET)
//public String getImageListPro( Model model) {
//    List<FileResponseDto> fileResponseDtos = new ArrayList<>();
//    List<File> files = fileService.getAllImage();
//    files.forEach(file -> {
//        String fileUrl = ServletUriComponentsBuilder
//                .fromCurrentContextPath()
//                .path("/file/")
//                .path(String.valueOf(file.getId()))
//                .toUriString();
//
//        FileResponseDto fileResponseDto = new FileResponseDto();
//        fileResponseDto.setName(file.getName());
//        fileResponseDto.setUrl(fileUrl);
//        System.out.println("****"+fileResponseDto.getUrl());
//        fileResponseDtos.add(fileResponseDto);
//    });
//    System.out.println(fileResponseDtos.toString());
//    model.addAttribute("images", fileResponseDtos);
//
//    return "admin/productlist";
//}


    @RequestMapping(value = "/requesIdPro", method = RequestMethod.GET)
    public String getFilePro(@RequestParam("id")int id, Model model) {
        List<FileResponseDto> fileResponseDtos = new ArrayList<>();
        List<File> files = fileService.getAllIByPro(id);
        files.forEach(file -> {
            String fileUrl = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/file/")
                    .path(String.valueOf(file.getId()))
                    .toUriString();

            FileResponseDto fileResponseDto = new FileResponseDto();
            fileResponseDto.setName(file.getName());
            fileResponseDto.setUrl(fileUrl);

            fileResponseDtos.add(fileResponseDto);
        });

        model.addAttribute("files", fileResponseDtos);

        return "admin/image";
    }


    @RequestMapping(value = "/reqPro", method = RequestMethod.GET)
    public String getImagePro(@RequestParam("id")int id, Model model) {
        File files = fileService.getProById(id);
            String fileUrl = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/file/")
                    .path(String.valueOf(files.getId()))
                    .toUriString();

            FileResponseDto fileResponseDto = new FileResponseDto();
            fileResponseDto.setName(files.getName());
            fileResponseDto.setUrl(fileUrl);


        model.addAttribute("files", fileResponseDto);
        System.out.println("tesr" +fileResponseDto.getUrl());
        return "admin/image";
    }

    @RequestMapping(value = "/file/upload", method = RequestMethod.GET, produces = "text/plain")
    public String upload( Model model) {
        model.addAttribute("image", new File());
        Map<Integer, String> cateMap = new HashMap<>();
        List<Product> stores = productService.getAllPro();
        for (Product p : stores) {
            cateMap.put(p.getId(),p.getName());
        }
        model.addAttribute("cate",cateMap);
        System.out.println("abcccccc");
        return "admin/uploads";
    }

    @RequestMapping(value = "/file/add", method = RequestMethod.POST, produces = "text/plain")
    public String upload(@RequestParam("file") MultipartFile file,@ModelAttribute File image,
                         Model model) {
        try {
            image.setName(file.getOriginalFilename());
            image.setContent(file.getBytes());
            image.setType(file.getContentType());
            fileService.addFile(image);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "redirect:/";
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        File fileDB = fileService.getFileById(Integer.parseInt(id));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getContent());
    }
}

