package com.diplock.library.mapper;

import com.diplock.library.dataholders.RoleDh;
import com.diplock.library.dtos.RoleDTO;
import com.diplock.library.entities.Role;
import com.diplock.library.entities.enums.ERole;
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
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDTO asDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setRoleId( role.getRoleId() );
        if ( role.getName() != null ) {
            roleDTO.setName( role.getName().name() );
        }

        return roleDTO;
    }

    @Override
    public Role asEntity(RoleDh roleDh) {
        if ( roleDh == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.roleId( roleDh.getRoleId() );
        if ( roleDh.getName() != null ) {
            role.name( Enum.valueOf( ERole.class, roleDh.getName() ) );
        }

        return role.build();
    }

    @Override
    public List<RoleDTO> asDtoList(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( roles.size() );
        for ( Role role : roles ) {
            list.add( asDto( role ) );
        }

        return list;
    }

    @Override
    public List<Role> asEntityList(List<RoleDh> roleDhs) {
        if ( roleDhs == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( roleDhs.size() );
        for ( RoleDh roleDh : roleDhs ) {
            list.add( asEntity( roleDh ) );
        }

        return list;
    }
}
