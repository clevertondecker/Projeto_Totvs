package br.com.totvs.sistemaescolar.core.professor.repository;

import java.sql.Types;

import javax.persistence.EntityManager;

import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.totvs.tjf.repository.aggregate.CrudAggregateRepository;

import br.com.totvs.sistemaescolar.core.professor.domain.model.Professor;
import br.com.totvs.sistemaescolar.core.professor.domain.model.ProfessorDomainRepository;

@Repository
public class ProfessorRepository extends CrudAggregateRepository<Professor, String>
		implements ProfessorDomainRepository {

	public ProfessorRepository(EntityManager em, ObjectMapper mapper) {
		super(em, mapper.copy());
	}

	@Override
	protected String getTableName() {
		return "professor";
	}

	public boolean checkIfExistsByCpf(String cpf) {
		System.out.println("CPF " + cpf);
		return this.exists("data->'cpf'->>'numero' = ?", new SqlParameterValue(Types.VARCHAR, cpf));
	}

}