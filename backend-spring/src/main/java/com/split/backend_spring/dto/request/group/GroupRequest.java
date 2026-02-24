package com.split.backend_spring.dto.request.group;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GroupRequest {

    private String name;
    private String description;

}
