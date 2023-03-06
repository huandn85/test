package service;

import entity.File;
import entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    File store(MultipartFile file) throws IOException;
    public void addFile(File file);
    List<File> getFiles();
    File getFileById(int id);
    List<File> getAllIByPro(int id);
    File getProById(int id);
    List<File> getIPI();
    List<File> getAllImage();
}
