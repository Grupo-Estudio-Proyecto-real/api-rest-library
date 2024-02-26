package com.diplock.library.services.role;

import com.diplock.library.dataholders.RoleDh;
import com.diplock.library.dtos.RoleDTO;
import java.util.List;

public interface RoleService {
  List<RoleDTO> findAll();

  RoleDTO findById(String id);

  RoleDTO save(RoleDh roleDh);

  RoleDTO update(String id, RoleDh roleDh);

  Boolean deleteById(String id);

}
