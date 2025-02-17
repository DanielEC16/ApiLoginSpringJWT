package com.spring.security.persistence.repository;

import com.spring.security.persistence.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
    Optional<UserEntity> findUserEntityByUsername(String username);
}
