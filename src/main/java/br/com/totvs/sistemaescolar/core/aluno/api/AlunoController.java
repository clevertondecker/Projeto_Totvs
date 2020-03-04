package br.com.totvs.sistemaescolar.core.aluno.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.totvs.tjf.core.validation.ValidatorService;

import br.com.totvs.sistemaescolar.core.aluno.application.AlunoApplicationService;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.aluno.exception.CriarAlunoException;
import br.com.totvs.sistemaescolar.core.pessoa.domain.model.CPF;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/alunos/")
public class AlunoController {
	
	@Autowired
	private AlunoApplicationService service;

	@Autowired
	private ValidatorService validator;

//	 private static final Logger log =
//	 LoggerFactory.getLogger(UserCommandService.class);

	@ApiOperation(value = "API para adicionar um aluno", httpMethod = "POST", consumes = APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Aluno criado."), })

	@PostMapping
	@RequestMapping("adicionar")
	public ResponseEntity<Void> adicionarAluno(@Valid @RequestBody CriarAlunoCommandDto alunoDto,
			BindingResult result) {

		validator.validate(alunoDto).ifPresent( violations -> { 
			throw new CriarAlunoException(violations); 
		});
			
		var cmd = CriarAlunoCommand.of(
				AlunoId.generate(),
				alunoDto.getNome(),
				alunoDto.getEmail(),
				CPF.of(alunoDto.getCpf().getNumero()),
				alunoDto.getFormaIngresso(),
				alunoDto.getMatricula(),
				alunoDto.getTurma());
		
		AlunoId id = service.handle(cmd);
			
		return ResponseEntity.created(
				ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/")
				.path(id.toString())
				.build().toUri())
				.build();
	}

}
