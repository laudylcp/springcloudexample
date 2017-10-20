package com.laudy.simpleuserservice.dao;

import com.laudy.simpleuserservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
