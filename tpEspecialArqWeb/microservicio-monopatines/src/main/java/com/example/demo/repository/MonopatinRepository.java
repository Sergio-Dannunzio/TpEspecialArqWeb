package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.MonopatinKmRecorridosDTO;
import com.example.demo.dto.MonopatinTiempoDTO;
import com.example.demo.dto.MonopatinesEstadosDTO;
import com.example.demo.model.Monopatin;

@Repository
public interface MonopatinRepository extends CrudRepository<Monopatin, Long>{

    @Query("""
    		SELECT new com.example.demo.dto.MonopatinesEstadosDTO (COUNT(CASE WHEN m.estado LIKE 'disponible' THEN 1 ELSE NULL END),
    		COUNT(CASE WHEN m.estado LIKE 'mantenimiento' THEN 1 ELSE NULL END))
    		FROM Monopatin m
    		""")
    MonopatinesEstadosDTO getEstados();
    
    @Query("""
            SELECT new com.example.demo.dto.MonopatinKmRecorridosDTO(m.id, SUM(v.km_recorridos)) 
            FROM Viaje v
            JOIN Monopatin m ON m.id = v.id_monopatin
            WHERE v.fin IS NOT NULL
            GROUP BY m.id
            ORDER BY SUM(v.km_recorridos) DESC
            """)
    List<MonopatinKmRecorridosDTO> traerOrdenadosPorKilometrosDESC();
    
    @Query("""
            SELECT new com.example.demo.dto.MonopatinTiempoDTO (m.id, CAST(SUM(v.fin) - SUM(v.inicio) AS LONG), CAST((SUM(v.fin) - SUM(v.inicio)) - SUM(v.segundos_estacionado) AS LONG), SUM(v.segundos_estacionado))
            FROM Viaje v
            JOIN Monopatin m ON m.id = v.id_monopatin
            WHERE v.fin IS NOT NULL
            AND v.segundos_estacionado IS NOT NULL 
            AND v.segundos_estacionado > 0
            GROUP BY m.id
            ORDER BY (SUM(v.fin) - SUM(v.inicio)) DESC
            """)
    List<MonopatinTiempoDTO> traerOrdenadosPorTiempoConPausasDESC();

   @Query("""
            SELECT new com.example.demo.dto.MonopatinTiempoDTO(m.id, CAST(SUM(v.fin) - SUM(v.inicio) AS LONG), CAST((SUM(v.fin) - SUM(v.inicio)) - SUM(v.segundos_estacionado) AS LONG), SUM(v.segundos_estacionado))
            FROM Viaje v
            JOIN Monopatin m ON m.id = v.id_monopatin
            WHERE v.fin IS NOT NULL
            AND v.segundos_estacionado = 0
            OR v.segundos_estacionado IS NULL
            ORDER BY (SUM(v.fin) - SUM(v.inicio)) DESC
            """)
    List<MonopatinTiempoDTO> traerOrdenadosPorTiempoSinPausasDESC();

   @Query("""
           SELECT m
           FROM Monopatin m
           WHERE m.locacion = :locacion
           """)
    List<Monopatin> findByLocacion(String locacion);

}