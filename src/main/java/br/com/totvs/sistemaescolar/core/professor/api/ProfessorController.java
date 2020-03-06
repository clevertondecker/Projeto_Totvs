package br.com.totvs.sistemaescolar.core.professor.api;

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

import br.com.totvs.sistemaescolar.core.pessoa.domain.model.CPF;
import br.com.totvs.sistemaescolar.core.professor.application.ProfessorApplicationService;
import br.com.totvs.sistemaescolar.core.professor.domain.model.ProfessorId;
import br.com.totvs.sistemaescolar.core.professor.exception.CriarProfessorException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/professores/")
public class ProfessorController {

	@Autowired
	private ProfessorApplicationService service;

	@Autowired
	private ValidatorService validator;

	@ApiOperation(value = "API para adicionar um professores", httpMethod = "POST", consumes = APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Professor criado."), })

	@PostMapping
	@RequestMapping("adicionar")
	public ResponseEntity<Void> adicionarProfessor(@Valid @RequestBody CriarProfessorCommandDto professorDto,
			BindingResult result) {

		validator.validate(professorDto).ifPresent(violations -> {
			throw new CriarProfessorException(violations);
		});

		var cmd = CriarProfessorCommand.of(
				ProfessorId.generate(), 
				professorDto.getNome(), 
				professorDto.getEmail(),
				CPF.of(professorDto.getCpf().getNumero()), 
				professorDto.getTitulo(),
				professorDto.getDisciplinaId());

		ProfessorId id = service.handle(cmd);

		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/").path(id.toString()).build().toUri())
				.build();
	}

}
