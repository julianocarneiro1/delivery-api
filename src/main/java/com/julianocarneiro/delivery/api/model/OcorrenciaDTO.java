package com.julianocarneiro.delivery.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaDTO {

	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;
	
}
