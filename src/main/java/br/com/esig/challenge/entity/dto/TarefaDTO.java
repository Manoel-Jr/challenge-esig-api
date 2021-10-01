package br.com.esig.challenge.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TarefaDTO {

	private Long id;
	private String titulo;
	private String responsavel;
	private String situacao;
}
