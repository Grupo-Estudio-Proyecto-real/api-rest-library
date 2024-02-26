package com.diplock.library.dataholders;

import com.diplock.library.entities.User;
import java.util.List;
import lombok.Data;

@Data
public class RoleDh {

  private String name;

  private String description;

  private List<User> userList;

}
