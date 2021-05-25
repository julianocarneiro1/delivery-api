package com.julianocarneiro.delivery.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julianocarneiro.delivery.domain.exception.EntidadeNaoEncontradaException;
import com.julianocarneiro.delivery.domain.model.Entrega;
import com.julianocarneiro.delivery.domain.repository.EntregaRepository;

@Service
public class BuscaEntregaService {
	
	@Autowired
	public EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}

}
