package com.robertodev.springsecuritycrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertodev.springsecuritycrud.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	List<Users> findByNomeIgnoreCaseContaining(String nome);
	
}
