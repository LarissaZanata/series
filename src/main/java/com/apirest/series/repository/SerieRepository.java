package com.apirest.series.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.apirest.series.models.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long>{
	
	List<Serie> findByNome(String nome);

}
