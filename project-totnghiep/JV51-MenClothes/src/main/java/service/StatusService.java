package service;

import entity.Category;
import entity.Status;

import java.util.List;

public interface StatusService  {
    List<Status> getAllSta();
    void addCate(Status status);
}
