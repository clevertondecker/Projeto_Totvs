package br.com.totvs.sistemaescolar.core.turma.repository;

import java.sql.Types;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.totvs.tjf.repository.aggregate.CrudAggregateRepository;

import br.com.totvs.sistemaescolar.core.turma.domain.model.Turma;
import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaDomainRepository;


@Repository
public class TurmaRepository extends CrudAggregateRepository<Turma, String> implements TurmaDomainRepository  {

	public TurmaRepository(EntityManager em, ObjectMapper mapper) {
		super(em, mapper.copy());
	}
	
	@Override
	protected String getTableName() {
		return "turma";
	}


}