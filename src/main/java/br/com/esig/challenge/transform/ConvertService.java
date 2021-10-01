package br.com.esig.challenge.transform;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.esig.challenge.entity.dto.TarefaDTO;
import br.com.esig.challenge.entity.Tarefa;

@Service
public class ConvertService {

	@Autowired
	private ModelMapper modelMapper;

	public Tarefa convertToTarefa(TarefaDTO dto) {
		return modelMapper.map(dto, Tarefa.class);
	}

	public TarefaDTO convertToTerefaDTO(Tarefa tarefa) {
		return modelMapper.map(tarefa, TarefaDTO.class);
	}
}
