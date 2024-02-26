package com.diplock.library.dataholders;

import com.diplock.library.entities.Role;
import java.util.List;
import lombok.Data;

@Data
public class UserDh {

  private Long userId;

  private String username;

  private String email;

  private String password;

  private Role role;

}

