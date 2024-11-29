package com.oraclealura.Literatura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oraclealura.Literatura.model.Autor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombre(String nombre);

    @Query("SELECT a FROM Autor a WHERE " +
            "(a.fechaDeNacimiento <= :anio AND (a.fechaDeMuerte >= :anio OR a.fechaDeMuerte IS NULL))")
    List<Autor> findByYear(@Param("anio") int anio);


}