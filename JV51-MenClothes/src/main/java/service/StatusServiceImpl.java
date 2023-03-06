package service;

import entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StatusRepository;

import java.util.List;

@Service(value = "statusService")
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;


    @Override
    public List<Status> getAllSta() {
        return (List<Status>)statusRepository.findAll() ;
    }

    @Override
    public void addCate(Status status) {
        statusRepository.save(status);
    }
}
