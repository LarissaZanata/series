package com.apirest.series.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.series.models.Serie;
import com.apirest.series.repository.SerieRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/apirest")
@Api(value="API REST Series")
@CrossOrigin(origins="*")
public class SerieResources {

	@Autowired
	SerieRepository serieRepository;
	
	@GetMapping("/series")
	@ApiOperation(value="Retorna uma lista de séries.")
	public List<Serie> listaSeries(){
		return serieRepository.findAll();
	}
	
	@GetMapping("/series/{nome}")
	@ApiOperation(value="Retorna todas as temporadas a partir do nome da série.")
	public List<Serie> listaSeriesPorNome(@PathVariable(value="nome")String nome){
		return serieRepository.findByNome(nome);
	}
	
	
	@PostMapping("/series")
	@ApiOperation(value="Grava uma temporada de uma série.")
	public Serie salvarSerie(@RequestBody Serie serie) {
		return serieRepository.save(serie);
	}
	
	@PutMapping("/series")
	@ApiOperation(value="Atualiza uma série.")
	public Serie editarSerie(@RequestBody Serie serie) {
		return serieRepository.save(serie);
	}
	
	@DeleteMapping("/series")
	@ApiOperation(value="Deleta uma série.")
	public void removeSErie(@RequestBody Serie serie) {
		serieRepository.delete(serie);
	}
}
