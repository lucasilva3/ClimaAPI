package com.servidor.clima.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.servidor.clima.model.Clima;
import com.servidor.clima.repository.ClimaRepository;

@Service
public class ClimaService {
	
	@Autowired
	private ClimaRepository _climaRepository;
	
	public List<Clima> listagem() {
		return _climaRepository.findAll();
	}
	
	public Clima salvar(@RequestBody Clima _clima) {
		return _climaRepository.save(_clima);
	}
	
	public boolean deletar(Long _id) {
		Optional<Clima> climaOptional = _climaRepository.findById(_id);
		if (climaOptional.isPresent()) {
			_climaRepository.deleteById(_id);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void deletarTudo() {
		_climaRepository.deleteAll();
	}
	
	public Optional<Clima> buscar(Long _id) {
		return _climaRepository.findById(_id);
	}
}

















