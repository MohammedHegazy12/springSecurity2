package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("""
			SELECT U FROM User U WHERE U.username = :username
			""")
	Optional<User>findByUsername(String username);
}
