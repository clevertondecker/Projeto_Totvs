package br.com.totvs.sistemaescolar.core.disciplina.repository;

import java.sql.Types;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.totvs.tjf.repository.aggregate.CrudAggregateRepository;

import br.com.totvs.sistemaescolar.core.disciplina.domain.model.Disciplina;
import br.com.totvs.sistemaescolar.core.disciplina.domain.model.DisciplinaDomainRepository;

@Repository
public class DisciplinaRepository extends CrudAggregateRepository<Disciplina, String>
		implements DisciplinaDomainRepository {

	public DisciplinaRepository(EntityManager em, ObjectMapper mapper) {
		super(em, mapper.copy());
	}

	@Override
	protected String getTableName() {
		return "disciplina";
	}

	public Optional<Disciplina> getByDisciplinaId(String disciplinaId) {
		return this.findOne("data->'id'->>'id' = ?", new SqlParameterValue(Types.VARCHAR, disciplinaId));
	}

	

}