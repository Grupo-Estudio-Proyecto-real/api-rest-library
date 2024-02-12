package com.diplock.library.mapper;

import com.diplock.library.dataholders.UserDh;
import com.diplock.library.dtos.UserDTO;
import com.diplock.library.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-12T20:42:49+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO asDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setRoles( UserMapper.mapToStrings( user.getRoles() ) );
        userDTO.setUsername( user.getUsername() );
        userDTO.setEmail( user.getEmail() );

        return userDTO;
    }

    @Override
    public User asEntity(UserDh userDh) {
        if ( userDh == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( userDh.getUsername() );
        user.email( userDh.getEmail() );
        user.password( userDh.getPassword() );

        return user.build();
    }

    @Override
    public List<UserDTO> asDtoList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( asDto( user ) );
        }

        return list;
    }

    @Override
    public List<User> asEntityList(List<UserDh> userDhList) {
        if ( userDhList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDhList.size() );
        for ( UserDh userDh : userDhList ) {
            list.add( asEntity( userDh ) );
        }

        return list;
    }

    @Override
    public void update(UserDh userDh, User user) {
        if ( userDh == null ) {
            return;
        }

        if ( userDh.getUsername() != null ) {
            user.setUsername( userDh.getUsername() );
        }
        if ( userDh.getEmail() != null ) {
            user.setEmail( userDh.getEmail() );
        }
        if ( userDh.getPassword() != null ) {
            user.setPassword( userDh.getPassword() );
        }
    }
}
