package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Viaje;

@Repository
public interface ViajeRepository extends CrudRepository<Viaje, Long>{

    @Query("""
            SELECT v 
            FROM Viaje v 
            WHERE EXTRACT(YEAR FROM v.fin) = :anio
            GROUP BY v.id_monopatin
            HAVING count(v.fin) > :cantidad
            """)
    List<Viaje> cantidadViajesMayorAAnioo(Integer cantidad, Integer anio);
    
    @Query("""
    		SELECT SUM(v.costo_total_viaje) 
    		FROM Viaje v 
    		WHERE MONTH(v.inicio) >= :mes1
    		AND MONTH(v.inicio) <= :mes2
    		AND YEAR(v.inicio) = :anio
    		""")
    Double getTotalFacturadoEntre(int mes1, int mes2, int anio);
}
