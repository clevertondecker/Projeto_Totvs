package br.com.totvs.sistemaescolar.core.turma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaDomainRepository;

@Service
public class TurmaDomainService {

	@Autowired
	TurmaDomainRepository turmaDomainRepository;
	
}