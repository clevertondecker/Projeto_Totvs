package br.com.totvs.sistemaescolar.core.aluno.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.totvs.tjf.repository.aggregate.CrudAggregateRepository;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.alunoDomainRepository;

@Repository
public class AlunoRepository extends CrudAggregateRepository<Aluno, String> implements alunoDomainRepository  {

	public AlunoRepository(EntityManager em, ObjectMapper mapper) {
		super(em, mapper);
	}

}