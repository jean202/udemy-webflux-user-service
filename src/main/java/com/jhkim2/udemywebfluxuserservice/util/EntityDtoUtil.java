package com.jhkim2.udemywebfluxuserservice.util;

import com.jhkim2.udemywebfluxuserservice.dto.TransactionRequestDto;
import com.jhkim2.udemywebfluxuserservice.dto.TransactionResponseDto;
import com.jhkim2.udemywebfluxuserservice.dto.TransactionStatus;
import com.jhkim2.udemywebfluxuserservice.dto.UserDto;
import com.jhkim2.udemywebfluxuserservice.entity.User;
import com.jhkim2.udemywebfluxuserservice.entity.UserTransaction;
import java.time.LocalDateTime;
import org.springframework.beans.BeanUtils;


public class EntityDtoUtil {

    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    public static User toEntity(UserDto dto){
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }

    public static UserTransaction toEntity(TransactionRequestDto requestDto) {
        UserTransaction ut = new UserTransaction();
        ut.setId(requestDto.getUserId());
        ut.setAmount(requestDto.getAmount());
        ut.setTransactionDate(LocalDateTime.now());
        return ut;
    }

    public static TransactionResponseDto toDto(TransactionRequestDto requestDto, TransactionStatus status) {
        TransactionResponseDto responseDto = new TransactionResponseDto();
        responseDto.setAmount(requestDto.getAmount());
        responseDto.setUserId(requestDto.getUserId());
        responseDto.setStatus(status);
        return responseDto;
    }


}
