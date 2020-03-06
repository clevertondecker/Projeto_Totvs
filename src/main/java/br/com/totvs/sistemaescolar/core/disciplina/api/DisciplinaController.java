package br.com.totvs.sistemaescolar.core.disciplina.api;

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

import br.com.totvs.sistemaescolar.core.disciplina.application.DisciplinaApplicationService;
import br.com.totvs.sistemaescolar.core.disciplina.domain.model.DisciplinaId;
import br.com.totvs.sistemaescolar.core.disciplina.exception.CriarDisciplinaException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/disciplina/")
public class DisciplinaController {

	@Autowired
	private DisciplinaApplicationService service;

	@Autowired
	private ValidatorService validator;

//	 private static final Logger log =
//	 LoggerFactory.getLogger(UserCommandService.class);

	@ApiOperation(value = "API para adicionar uma disciplina, também permite adicionar a disciplina já vinculada a uma turma", httpMethod = "POST", consumes = APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Disciplina criada."), })

	@PostMapping
	@RequestMapping("adicionar")
	public ResponseEntity<Void> adicionarDisciplina(@Valid @RequestBody CriarDisciplinaCommandDto disciplinaDto,
			BindingResult result) {

		validator.validate(disciplinaDto).ifPresent(violations -> {
			throw new CriarDisciplinaException(violations);
		});
		
		var cmd = CriarDisciplinaCommand.of(DisciplinaId.generate(), 
				disciplinaDto.getDescricao(),
				disciplinaDto.getSigla(), 
				disciplinaDto.getCargaHoraria(), 
				disciplinaDto.getTurmaId(),
				disciplinaDto.getProfessorId());

		DisciplinaId id = service.handle(cmd);

		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/").path(id.toString()).build().toUri())
				.build();
	}

}
