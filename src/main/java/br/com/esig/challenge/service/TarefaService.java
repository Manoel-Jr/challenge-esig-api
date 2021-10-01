package br.com.esig.challenge.service;

import br.com.esig.challenge.entity.Tarefa;
import br.com.esig.challenge.entity.dto.TarefaDTO;

import java.util.List;

public interface TarefaService {

	Tarefa criarTarefa(TarefaDTO tarefaDTO);

	Tarefa buscarTarefaPorId(Long id);

	List<Tarefa> buscarTarefaPorResponsavel(String responsavel);

	List<Tarefa> buscarTarefaPorTitulo(String titulo);

	List<Tarefa> buscarPorSituacao(String situacao);

	List<Tarefa> listarTodos();

	void deletaTarefaPorId(Long id);

	Tarefa atualizarTarefa(Long id, Tarefa tarefa);

	void excluirTarefaPorId(Long id);

	Tarefa alterarSituacao(Long id);

}
