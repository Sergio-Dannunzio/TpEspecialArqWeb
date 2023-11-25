package com.example.demo.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	@Query("SELECT u FROM Usuario u WHERE u.username = :nombre")
	Optional<Usuario> findByUsername(String nombre);

	//@Query("SELECT u From Usuario u JOIN FETCH u.roles WHERE u.email = :email ")
	//Optional<Usuario> findUserByEmailIgnoreCase( String email );
}
