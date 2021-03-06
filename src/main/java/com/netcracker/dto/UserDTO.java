package com.netcracker.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private boolean isCaptain;
    private String userName;
}
