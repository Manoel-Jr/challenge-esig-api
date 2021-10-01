package br.com.esig.challenge.service.impl;

import br.com.esig.challenge.entity.Tarefa;
import br.com.esig.challenge.entity.dto.TarefaDTO;
import br.com.esig.challenge.respository.TarefaRepository;
import br.com.esig.challenge.service.TarefaService;
import br.com.esig.challenge.transform.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaServiceImpl implements TarefaService {

    public static final String EM_ANDAMENTO = "EM_ANDAMENTO";
    public static final String CONCLUIDO = "CONCLUIDO";

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ConvertService mapper;

    @Override
    public Tarefa criarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = mapper.convertToTarefa(tarefaDTO);
        tarefa.setSituacao(EM_ANDAMENTO);
        return tarefaRepository.save(tarefa);
    }

    @Override
    public Tarefa buscarTarefaPorId(Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.orElse(null);
    }

    @Override
    public void deletaTarefaPorId(Long id) {
        tarefaRepository.deleteById(id);
    }

    @Override
    public Tarefa atualizarTarefa(Long id, Tarefa tarefa) {
        tarefa.setId(id);
        tarefa.setSituacao(tarefa.getSituacao());
        return tarefaRepository.save(tarefa);
    }

    @Override
    public List<Tarefa> buscarTarefaPorResponsavel(String responsavel) {
        return tarefaRepository.findByResponsavelContainingIgnoreCase(responsavel);
    }

    @Override
    public void excluirTarefaPorId(Long id) {
        tarefaRepository.deleteById(id);
    }

    @Override
    public Tarefa alterarSituacao(Long id) {
        Tarefa tarefa = buscarTarefaPorId(id);
        tarefa.setSituacao(CONCLUIDO);
        return tarefaRepository.save(tarefa);
    }

    @Override
    public List<Tarefa> buscarTarefaPorTitulo(String titulo) {
        return tarefaRepository.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<Tarefa> buscarPorSituacao(String situacao) {
        return tarefaRepository.findBySituacaoContainingIgnoreCase(situacao);
    }

    @Override
    public List<Tarefa> listarTodos() {
        return tarefaRepository.findAll();
    }

}
