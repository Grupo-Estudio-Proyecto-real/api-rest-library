package com.diplock.library.services.user;

import com.diplock.library.dataholders.UserDh;
import com.diplock.library.dtos.UserDTO;
import com.diplock.library.entities.Role;
import com.diplock.library.entities.User;
import com.diplock.library.exceptions.BdNotFoundException;
import com.diplock.library.exceptions.BdNotSaveException;
import com.diplock.library.mapper.UserMapper;
import com.diplock.library.parsers.BdParser;
import com.diplock.library.repositories.RoleRepository;
import com.diplock.library.repositories.UserRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StopWatch;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  @NonNull
  private UserRepository userRepository;

  @NonNull
  private RoleRepository roleRepository;

  @NonNull
  private UserMapper userMapper;

  private BdParser bdParser = new BdParser();

  @Override
  public List<UserDTO> findALl() {

    final List<User> users = (List<User>) userRepository.findAll();

    if (CollectionUtils.isEmpty(users)) {
      log.warn("There are no users in the database");
      return Collections.emptyList();
    }

    return userMapper.asDtoList(users);
  }

  @Override
  public UserDTO findById(final Long id) {
    final Optional<User> user = userRepository.findById(id);

    if (user.isPresent()) {
      return userMapper.asDto(user.get());
    } else {
      throw new BdNotFoundException("GET - There is no user in the database with the id: " + id);
    }
  }

  @Override
  public UserDTO save(final UserDh userDh) {
    bdParser.Evaluator(userDh, "POST");

    final User user = userMapper.asEntity(userDh);

    final User userSaved = userRepository.save(user);

    return this.userMapper.asDto(userSaved);
  }


  @Override
  public UserDTO update(Long id, UserDh userDh) {

    bdParser.Evaluator(userDh, "PUT");
    if (userDh.getUserId() != id) {
      throw new BdNotSaveException("PUT - Parameters are incorrect for field userId: " + userDh.getUserId() + " is different at id: " + id);
    }

    final User user = userMapper.asEntity(userDh);
    final boolean existsUser = userRepository.existsById(id);

    if (existsUser) {
      final User userSaved = userRepository.save(user);

      return userMapper.asDto(user);
    }

    throw new BdNotFoundException("PUT - There is no user in the database with the id: " + id);
  }

  @Override
  public UserDTO updateById(Long id, UserDh userDh) {

    bdParser.Evaluator(userDh, "PUT");
    if (userDh.getUserId() != id) {
      throw new BdNotSaveException("PUT - Parameters are incorrect for field userId: " + userDh.getUserId() + " is different at id: " + id);
    }

    Optional<User> optionalUser = userRepository.findById(id);
    final boolean existsUser = optionalUser.isPresent();

    if (existsUser) {
      User user = optionalUser.get();

      User updatedUser = userRepository.save(user);

      return this.userMapper.asDto(updatedUser);
    }

    throw new BdNotFoundException("PUT - There is no user in the database with the id: " + id);
  }

  @Override
  public Boolean deleteById(final Long id) {

    final boolean existsUser = this.userRepository.existsById(id);
    if (existsUser) {
      this.userRepository.deleteById(id);
      return true;
    }

    throw new BdNotFoundException("DELETE - There is no user in the database with the id: " + id);
  }
}
