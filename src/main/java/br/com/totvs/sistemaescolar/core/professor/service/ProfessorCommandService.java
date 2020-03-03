package br.com.totvs.sistemaescolar.core.professor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.sistemaescolar.core.professor.domain.model.ProfessorDomainRepository;


@Service
public class ProfessorCommandService {
	
	@Autowired
	ProfessorDomainRepository professorDomainRepository;

}
