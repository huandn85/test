package service;

import entity.UpFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MRepository;
@Service(value = "mService")
public class MServiceImpl implements MService{
    @Autowired
    private MRepository mRepository;
    public UpFile saveImage(UpFile upFile){
        return mRepository.save(upFile);
    }
}
