package com.julianocarneiro.delivery.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.julianocarneiro.delivery.api.assembler.EntregaAssembler;
import com.julianocarneiro.delivery.api.model.EntregaDTO;
import com.julianocarneiro.delivery.api.model.request.EntregaInput;
import com.julianocarneiro.delivery.domain.model.Entrega;
import com.julianocarneiro.delivery.domain.repository.EntregaRepository;
import com.julianocarneiro.delivery.domain.service.FinalizacaoEntregaService;
import com.julianocarneiro.delivery.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;
	private FinalizacaoEntregaService finalizacaoEntregaService;
	private ModelMapper modelMapper;
	private EntregaAssembler entregaAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDTO solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
		Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
		
		return entregaAssembler.toModel(entregaSolicitada);
	}
	
	@PutMapping("{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar (@PathVariable Long entregaId) {
		finalizacaoEntregaService.finalizar(entregaId);
	}
	
	@GetMapping
	public List<EntregaDTO> listar() {
		return entregaAssembler.toCollectionModel(entregaRepository.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> {
					EntregaDTO entregaDTO = modelMapper.map(entrega, EntregaDTO.class);
					
//					entregaDTO.setId(entrega.getId());
//					entregaDTO.setNomeCliente(entrega.getCliente().getNome());
//					entregaDTO.setDestinatario(new DestinatarioDTO());
//					entregaDTO.getDestinatario().setNome(entrega.getDestinatario().getNome());
//					entregaDTO.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
//					entregaDTO.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
//					entregaDTO.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
//					entregaDTO.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
//					entregaDTO.setTaxa(entrega.getTaxa());
//					entregaDTO.setStatus(entrega.getStatus());
//					entregaDTO.setDataPedido(entrega.getDataPedido());
//					entregaDTO.setDataFinalizacao(entrega.getDataFinalizacao());
					
					return ResponseEntity.ok(entregaDTO);
					
				}).orElse(ResponseEntity.notFound().build());
	}

}
