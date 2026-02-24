package com.split.backend_spring.service.impl;

import com.split.backend_spring.exception.group.GroupNotFoundException;
import com.split.backend_spring.exception.groupmember.GroupMemberNotFoundException;
import com.split.backend_spring.model.Group;
import com.split.backend_spring.model.GroupMember;
import com.split.backend_spring.model.User;
import com.split.backend_spring.repository.GroupMemberRepository;
import com.split.backend_spring.repository.GroupRepository;
import com.split.backend_spring.repository.UserRepository;
import com.split.backend_spring.service.GroupMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupMemberServiceImpl implements GroupMemberService {

    private final GroupMemberRepository groupMemberRepo;
    private final UserRepository userRepo;
    private final GroupRepository groupRepo;


}
