package com.choelinska.horrorlibz.repositories;

import com.choelinska.horrorlibz.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    @Override
    <S extends UserEntity> S save(S entity);
    <S extends UserEntity> S edit(S entity);
}
