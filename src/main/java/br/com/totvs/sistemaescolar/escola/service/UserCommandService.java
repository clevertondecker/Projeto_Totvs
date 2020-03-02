package br.com.totvs.sistemaescolar.escola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.sistemaescolar.aluno.entity.Aluno;
import br.com.totvs.sistemaescolar.aluno.repository.AlunoRepository;

@Service
public class UserCommandService {
	
	@Autowired
	AlunoRepository alunoRepository;

	public Aluno adicionar(Aluno u) {
		System.out.println("repository : "+ u.toString());
		return u;
	}
	
}