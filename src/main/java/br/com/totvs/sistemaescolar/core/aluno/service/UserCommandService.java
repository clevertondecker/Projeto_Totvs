package br.com.totvs.sistemaescolar.core.aluno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoDomainRepository;

@Service
public class UserCommandService {
	
	@Autowired
	AlunoDomainRepository alunoDomainRepository;

	public Aluno adicionar(Aluno u) {
		System.out.println("repository : "+ u.toString());
		return u;
	}
	
}