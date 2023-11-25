package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cuenta;

@Repository
public interface CuentaUsuarioRepository extends CrudRepository<Cuenta, Long>{

}
