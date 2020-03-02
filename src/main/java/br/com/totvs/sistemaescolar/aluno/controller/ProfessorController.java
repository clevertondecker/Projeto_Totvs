package br.com.totvs.sistemaescolar.aluno.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.totvs.sistemaescolar.escola.service.UserCommandService;
import br.com.totvs.sistemaescolar.response.Response;

public class ProfessorController {

	@Autowired
	private UserCommandService service;

//	/* EndPoint para criação do usuarío do tipo professor. */
//	@PostMapping
//	@RequestMapping("user/create/professor")
//	public ResponseEntity<Response<Professor>> adicionarProfessor(@Valid @RequestBody Professor professor, BindingResult result) {
//
//		Response<Professor> response = new Response<Professor>();
//		if (result.hasErrors()) {
//			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//		}
//
//		Professor user = service.save(professor);
//		response.setData(user);
//		return ResponseEntity.status(HttpStatus.CREATED).body(response);
//	}
}
