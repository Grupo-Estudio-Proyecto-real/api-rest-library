package com.diplock.library.dtos;

import com.diplock.library.entities.User;
import java.util.List;
import lombok.Data;

@Data
public class RoleDTO {

  private String name;

  private String description;

  private List<User> userList;
}
