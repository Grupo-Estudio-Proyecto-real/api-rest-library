package com.diplock.library.services.role;

import com.diplock.library.dataholders.RoleDh;
import com.diplock.library.dtos.RoleDTO;
import com.diplock.library.dtos.UserDTO;
import com.diplock.library.entities.Role;
import com.diplock.library.exceptions.BdNotFoundException;
import com.diplock.library.exceptions.BdNotSaveException;
import com.diplock.library.mapper.RoleMapper;
import com.diplock.library.parsers.BdParser;
import com.diplock.library.repositories.RoleRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StopWatch;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

  @NonNull
  private RoleRepository roleRepository;

  @NonNull
  private RoleMapper roleMapper;

  private BdParser bdParser = new BdParser();

  @Override
  public List<RoleDTO> findAll() {
    List<Role> roles = (List<Role>) roleRepository.findAll();

    if (CollectionUtils.isEmpty(roles)) {
      log.warn("There are no roles in the database");
      return Collections.emptyList();
    }

    return this.roleMapper.asDtoList(roles);
  }

  @Override
  public RoleDTO findById(final String id) {
    final Optional<Role> role = roleRepository.findById(id);
    final boolean isPresent = role.isPresent();

    if (isPresent) {
      return roleMapper.asDto(role.get());
    } else {
      throw new BdNotFoundException("GET - There is no role in the database with the id: " + id);
    }
  }

  @Override
  public RoleDTO save(final RoleDh roleDh) {
    bdParser.Evaluator(roleDh, "POST");
    final Role role = roleMapper.asEntity(roleDh);
    final Role roleSaved = roleRepository.save(role);
    return roleMapper.asDto(roleSaved);
  }

  @Override
  public RoleDTO update(final String id, final RoleDh roleDh) {
    bdParser.Evaluator(roleDh, "PUT");

    if (!roleDh.getName().equals(id)) {
      throw new BdNotSaveException("PUT - Parameters are incorrect for field name: " + roleDh.getName() + " is different at id: " + id);
    }

    final Role role = roleMapper.asEntity(roleDh);
    if (roleRepository.existsById(id)) {
      return roleMapper.asDto(roleRepository.save(role));
    }

    throw new BdNotFoundException("PUT - There is no role in the database with the id: " + id);
  }

  @Override
  public Boolean deleteById(final String id) {
    if (roleRepository.existsById(id)) {
      roleRepository.deleteById(id);
      return true;
    }
    throw new BdNotFoundException("DELETE - There is no role in the database with the id: " + id);
  }

}
