package com.sistema.ordenes.mapper;

import com.sistema.ordenes.dto.userRequestDto;
import com.sistema.ordenes.dto.userResponseDto;
import com.sistema.ordenes.model.User;

public class userMapper {
    //convertimos request en entidades
    public static User toEntity(userRequestDto dto){
        User user = new User();
        user.setName(dto.getName());
        user.setLastname(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setTelephone(dto.getTelephone());
        user.setAddress(dto.getAddress());
        user.setPassword(dto.getPassword());
        return user;
    }

    //convertimos entidaddes en response
    public static userResponseDto toResponse(User u){
        return new userResponseDto(u.getIdUser(),
                u.getName(),
                u.getLastname(),
                u.getEmail(),
                u.getTelephone(),
                u.getAddress());
    }
}
