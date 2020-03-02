package br.com.totvs.sistemaescolar.core.aluno.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totvs.sl.yms.core.pontocontrole.exception.YMSAlterarPontoControleException;
import com.totvs.tjf.core.validation.ValidatorService;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.aluno.service.UserCommandService;
import br.com.totvs.sistemaescolar.core.exception.CriarAlunoException;
import br.com.totvs.sistemaescolar.core.response.api.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/alunos/")
public class AlunoController {

	@Autowired
	private UserCommandService service;

	@Autowired
	private ValidatorService validator;

//	 private static final Logger log =
//	 LoggerFactory.getLogger(UserCommandService.class);

	@ApiOperation(value = "API para adicionar um aluno", httpMethod = "POST", consumes = APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Aluno criado."), })

	@PostMapping
	@RequestMapping("adicionar")
	public ResponseEntity<Response<Aluno>> adicionarAluno(@Valid @RequestBody CriarAlunoCommandDto alunoDto,
			BindingResult result) {

		validator.validate(alunoDto).ifPresent( violations -> { 
			throw new CriarAlunoException(violations); 
		});
		
		alunoDto = CriarAlunoCommand.of(
				AlunoId.generate(),
				alunoDto.getNome(),
				alunoDto.getEmail(),
				alunoDto.getCpf(),
				alunoDto.getFormaIngresso(),
				alunoDto.getMatricula());

		Response<Aluno> response = new Response<Aluno>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		Aluno user = service.adicionar(aluno);
		response.setData(user);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
