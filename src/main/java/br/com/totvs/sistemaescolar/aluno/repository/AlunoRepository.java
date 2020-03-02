package br.com.totvs.sistemaescolar.aluno.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.totvs.tjf.repository.aggregate.CrudAggregateRepository;

import br.com.totvs.sistemaescolar.aluno.entity.Aluno;

@Repository
public class AlunoRepository extends CrudAggregateRepository<Aluno, String> {

	public AlunoRepository(EntityManager em, ObjectMapper mapper) {
		super(em, mapper);
	}

}