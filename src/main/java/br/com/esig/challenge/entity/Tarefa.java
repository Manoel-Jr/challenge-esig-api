package br.com.esig.challenge.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@Table(name = "tb_tarefa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	private String responsavel;

	private String situacao;
}
