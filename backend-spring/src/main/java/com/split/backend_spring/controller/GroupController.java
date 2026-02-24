package com.split.backend_spring.controller;

import com.split.backend_spring.model.Group;
import com.split.backend_spring.model.GroupMember;
import com.split.backend_spring.model.Role;
import com.split.backend_spring.model.User;
import com.split.backend_spring.service.GroupMemberService;
import com.split.backend_spring.service.GroupService;
import com.split.backend_spring.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/group")
@RequiredArgsConstructor
@Tag(name = "Controller dei Group", description = "API per gestire i group")
public class GroupController {

    private final UserService userService;
    private final GroupService groupService;
    private final GroupMemberService groupMemberService;

    //-----TUTTI I POST-----

}
