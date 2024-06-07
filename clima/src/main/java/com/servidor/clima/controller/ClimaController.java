package com.servidor.clima.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servidor.clima.model.Clima;
import com.servidor.clima.service.ClimaService;

@RestController
@RequestMapping("/metereologia")
public class ClimaController {
	
	@Autowired
	private ClimaService _climaService;
	
	@GetMapping("/listagem")
	public List<Clima> listagem() {
		return _climaService.listagem();
	}
	
	@PostMapping("/salvar")
	public Clima salvar(@RequestBody Clima _clima) {
		return _climaService.salvar(_clima);
	}
	
	@DeleteMapping("/deletar/{_id}")
	public ResponseEntity<String> deletar(@PathVariable Long _id) {
		if (_climaService.deletar(_id)) {
			return ResponseEntity.ok("Registro climático deletado com sucesso!");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/deletarTudo")
	public ResponseEntity<String> deletarTudo() {
		_climaService.deletarTudo();
		return ResponseEntity.ok("Todos os registros metereológicos foram deletados.");
	}
	
	@GetMapping("/buscar/{_id}")
	public ResponseEntity<Clima> buscar(@PathVariable Long _id) {
		Optional<Clima> clima = _climaService.buscar(_id);
		if (clima.isPresent()) {
			return ResponseEntity.ok(clima.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}


}
















