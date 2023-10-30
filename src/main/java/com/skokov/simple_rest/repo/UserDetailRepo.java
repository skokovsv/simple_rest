package com.skokov.simple_rest.repo;


import com.skokov.simple_rest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepo extends JpaRepository<User,String> {
}
