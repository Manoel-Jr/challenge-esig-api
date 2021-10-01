package br.com.esig.challenge.respository;

import br.com.esig.challenge.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	List<Tarefa> findByResponsavelContainingIgnoreCase(String responsavel);

	List<Tarefa> findByTituloContainingIgnoreCase(String titulo);

	List<Tarefa> findBySituacaoContainingIgnoreCase(String situacao);
}
