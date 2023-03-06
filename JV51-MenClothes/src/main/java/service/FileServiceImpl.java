package service;

import entity.File;
import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import repository.FileRepository;
import repository.ProductRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "fileService")
public class FileServiceImpl implements FileService{
    @Autowired
    private FileRepository fileRepository;

    @Override
    public File store(MultipartFile file) throws IOException {
        File f = new File();
        return fileRepository.save(f);
    }
    @Override
    public void addFile(File file){
        fileRepository.save(file);
    }

    @Override
    public List<File> getFiles() {
        return (List<File>) fileRepository.findAllByOrderByIdDesc();
    }

    @Override
    public File getFileById(int id) {
        return fileRepository.findById(id).get();
    }

    @Override
    public List<File> getAllIByPro(int id){
        return (List<File>) fileRepository.findAllByProductId(id);
    }

    @Override
    public File getProById(int id) {
        return (File) fileRepository.findByProductId(id);
    }

    @Override
    public List<File> getIPI() {
        return (List<File>) fileRepository.getAllFilebyPi();
    }

    @Override
    public List<File> getAllImage() {
        return (List<File>)fileRepository.getAllFilebyPi();
    }
}
