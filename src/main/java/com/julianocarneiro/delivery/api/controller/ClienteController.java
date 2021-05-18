package com.julianocarneiro.delivery.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julianocarneiro.delivery.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("João");
		cliente1.setTelefone("34 99999-9009");
		cliente1.setEmail("joaodascouves@gmail.com");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Maria");
		cliente2.setTelefone("48 98899-1234");
		cliente2.setEmail("mariadasilva@gmail.com");
		
		return Arrays.asList(cliente1, cliente2);
	}

}
