package com.diplock.library.mapper;

import com.diplock.library.dataholders.UserDh;
import com.diplock.library.dtos.UserDTO;
import com.diplock.library.entities.Role;
import com.diplock.library.entities.User;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;


//@Mapper(componentModel = ComponentModel.SPRING)
@Mapper
public interface UserMapper {

  //@Mapping(source = "roles", target = "roles", qualifiedByName="toStrings")
  //@Mapping(target = "password", ignore = true)
  UserDTO asDto(User user);

  //@InheritInverseConfiguration
  //@Mapping(target = "roles", ignore = true)
  User asEntity(UserDh userDh);

  List<UserDTO> asDtoList (List<User> users);

  List<User> asEntityList (List<UserDh> userDhList);


}