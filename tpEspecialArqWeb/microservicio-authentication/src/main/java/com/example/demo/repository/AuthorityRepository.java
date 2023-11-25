package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Authority;


@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {

    @Query("""
            SELECT a
            FROM Authority a
            WHERE a.name=:nombre
            ORDER BY a.id
            LIMIT 1
            """)
    Optional<Authority> findByName(String nombre);
}