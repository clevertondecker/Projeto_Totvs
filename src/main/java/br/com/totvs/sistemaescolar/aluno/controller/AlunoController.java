package br.com.totvs.sistemaescolar.aluno.controller;

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

import br.com.totvs.sistemaescolar.aluno.entity.Aluno;
import br.com.totvs.sistemaescolar.aluno.entity.AlunoId;
import br.com.totvs.sistemaescolar.escola.service.UserCommandService;
import br.com.totvs.sistemaescolar.response.Response;
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

//	 private static final Logger log =
//	 LoggerFactory.getLogger(UserCommandService.class);
	
	@ApiOperation(value = "API para adicionar um aluno", httpMethod = "POST", consumes = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Aluno criado."),
	})
	
	
	@PostMapping
	@RequestMapping("adicionar")
	public ResponseEntity<Response<Aluno>> adicionarAluno(@Valid @RequestBody Aluno aluno, BindingResult result) {
		
		aluno = aluno.builder().id(AlunoId.generate())
		.nome(aluno.getNome())
		.email(aluno.getEmail())
		.cpf(aluno.getCpf())
		.formaIngresso(aluno.getFormaIngresso())
		.matricula(aluno.getMatricula()).build();
		
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
