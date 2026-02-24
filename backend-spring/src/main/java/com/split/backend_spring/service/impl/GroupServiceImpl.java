package com.split.backend_spring.service.impl;

import com.split.backend_spring.dto.request.group.GroupRequest;
import com.split.backend_spring.exception.group.GroupNotFoundException;
import com.split.backend_spring.model.Group;
import com.split.backend_spring.model.GroupMember;
import com.split.backend_spring.model.Role;
import com.split.backend_spring.model.User;
import com.split.backend_spring.repository.GroupMemberRepository;
import com.split.backend_spring.repository.GroupRepository;
import com.split.backend_spring.repository.UserRepository;
import com.split.backend_spring.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepo;
    private final UserRepository userRepo;
    private final GroupMemberRepository groupMemberRepo;


    @Override
    public Group findById(Long id) {
        return groupRepo.findById(id).orElseThrow(() -> new GroupNotFoundException("Grup with id: " + id + "not found")) ;
    }

    @Override
    public Group findByName(String name) {
        return groupRepo.findGroupByName(name).orElseThrow(() -> new GroupNotFoundException("Group with name: " + name + " not found"));
    }

    @Override
    public List<Group> findAll() {
        return groupRepo.findAll();
    }

    @Override
    public Group save(Group group) {
        return groupRepo.save(group);
    }

    @Override
    public void deleteById(Long id) {
            Group g = groupRepo.findById(id).orElseThrow(() -> new GroupNotFoundException("Group with id: " + id + "not found"));
            groupRepo.delete(g);
    }

    @Override
    public Group createGroup(Group group, Long creatorId) {
        // 1. Salva il gruppo per ottenere l'ID
        Group savedGroup = groupRepo.save(group);

        // 2. Recupera l'utente creatore
        User creator = userRepo.findById(creatorId).orElseThrow(() -> new RuntimeException("Creator user not found with ID: " + creatorId));

        // 3. Crea l'associazione GroupMember
        GroupMember membership = new GroupMember();
        membership.setGroup(savedGroup);
        membership.setUser(creator);
        // Imposta il ruolo di amministratore per il creatore
        membership.setRole(Role.ADMIN);
        membership.setJoinedAt(LocalDateTime.now());

        // 4. Salva il membro
        groupMemberRepo.save(membership);

        return savedGroup;
    }
}
