package com.split.backend_spring.service;

import com.split.backend_spring.model.Group;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {

    Group findById(Long id);
    Group findByName(String name);
    List<Group> findAll();
    Group  save(Group group);
    void deleteById(Long id);
    Group createGroup(Group group, Long creatorId);
}