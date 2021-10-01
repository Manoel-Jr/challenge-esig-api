package br.com.esig.challenge.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.esig.challenge.entity.Tarefa;
import br.com.esig.challenge.entity.dto.TarefaDTO;
import br.com.esig.challenge.service.TarefaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin("*")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	
	@ApiOperation(value = "Salva uma uma tarefa")
	@PostMapping
	public ResponseEntity<Tarefa> createAssignment(@RequestBody TarefaDTO dto) {
		return new ResponseEntity<>(tarefaService.criarTarefa(dto), HttpStatus.CREATED);
	}

	@ApiOperation(value = "buscar tarefa por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> searchById(@PathVariable Long id) {
		return new ResponseEntity<>(tarefaService.buscarTarefaPorId(id), HttpStatus.OK);
	}

	@ApiOperation(value = "buscar uma lista de trefa por titulo")
	@GetMapping("/buscar-por-titulo/{titulo}")
	public ResponseEntity<List<Tarefa>> searchByTitle(@PathVariable String titulo) {
		return new ResponseEntity<>(tarefaService.buscarTarefaPorTitulo(titulo), HttpStatus.OK);
	}

	@ApiOperation(value = "buscar uma lista de tarefa por situacao")
	@GetMapping("/buscar-por-situacao/{situacao}")
	public ResponseEntity<List<Tarefa>> searchBySituation(@PathVariable String situacao) {
		return new ResponseEntity<>(tarefaService.buscarPorSituacao(situacao), HttpStatus.OK);
	}

	@ApiOperation(value = "buscar uma lista de tarefa")
	@GetMapping
	public ResponseEntity<List<Tarefa>> findAll() {
		return new ResponseEntity<>(tarefaService.listarTodos(), HttpStatus.OK);
	}

	@ApiOperation(value = "deletar tarefa por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		tarefaService.deletaTarefaPorId(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "atualizando tarefa por ID")
	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> updateAssignment(@PathVariable Long id, @RequestBody Tarefa tarefa) {
		return new ResponseEntity<>(tarefaService.atualizarTarefa(id, tarefa), HttpStatus.OK);
	}
	
	@ApiOperation(value = " alterando situacao por ID")
	@PatchMapping("/{id}/situacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarSituacao(@PathVariable Long id) {
		tarefaService.alterarSituacao(id);
	}
}
