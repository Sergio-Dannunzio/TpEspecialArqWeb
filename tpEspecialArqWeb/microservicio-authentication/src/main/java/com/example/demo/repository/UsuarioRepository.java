package com.example.demo.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.LoginResponseDTO;
import com.example.demo.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	@Query("SELECT u FROM Usuario u WHERE u.username = :nombre")
	Optional<Object> findByUsername(String nombre);

	//@Query("SELECT u From Usuario u JOIN FETCH u.roles WHERE u.email = :email ")
	//Optional<Usuario> findUserByEmailIgnoreCase( String email );
}
