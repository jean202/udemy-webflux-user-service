package com.jhkim2.udemywebfluxuserservice.
    repository;

import com.jhkim2.udemywebfluxuserservice.entity.UserTransaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserTransactionRepository extends ReactiveCrudRepository<UserTransaction, Integer> {


}
