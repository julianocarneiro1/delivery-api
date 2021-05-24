package com.julianocarneiro.delivery.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.julianocarneiro.delivery.domain.model.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaDTO {
	
	private Long id;
	private String nomeCliente;
	private DestinatarioDTO destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;

}
