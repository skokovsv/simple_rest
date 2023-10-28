package com.skokov.simple_rest.repo;

import com.skokov.simple_rest.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message,Long> {

}
