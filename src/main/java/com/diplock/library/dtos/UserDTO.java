package com.diplock.library.dtos;

import com.diplock.library.entities.Role;
import java.util.Set;
import lombok.Data;

@Data
public class UserDTO {

  private Long userId;

  private String username;

  private String email;

  private String password;

  private Role role;

}
