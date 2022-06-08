package com.jhkim2.udemywebfluxuserservice.service;

import com.jhkim2.udemywebfluxuserservice.dto.TransactionRequestDto;
import com.jhkim2.udemywebfluxuserservice.dto.TransactionResponseDto;
import com.jhkim2.udemywebfluxuserservice.dto.TransactionStatus;
import com.jhkim2.udemywebfluxuserservice.repository.UserRepository;
import com.jhkim2.udemywebfluxuserservice.repository.UserTransactionRepository;
import com.jhkim2.udemywebfluxuserservice.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTransactionRepository transactionRepository;

    public Mono<TransactionResponseDto> createTransaction(final TransactionRequestDto requestDto) {
        return this.userRepository.updateUserBalance(requestDto.getUserId(), requestDto.getAmount())
                        .filter(Boolean::booleanValue)
                        .map(b -> EntityDtoUtil.toEntity(requestDto))
                        .flatMap(this.transactionRepository::save)
                        .map(ut -> EntityDtoUtil.toDto(requestDto, TransactionStatus.APPROVED))
                        .defaultIfEmpty(EntityDtoUtil.toDto(requestDto, TransactionStatus.DECLINED));

    }

}
