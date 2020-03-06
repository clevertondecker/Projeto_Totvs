package br.com.totvs.sistemaescolar.core.aluno.repository;

import java.sql.Types;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.totvs.tjf.repository.aggregate.CrudAggregateRepository;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoDomainRepository;

@Repository
public class AlunoRepository extends CrudAggregateRepository<Aluno, String> implements AlunoDomainRepository  {

	public AlunoRepository(EntityManager em, ObjectMapper mapper) {
		super(em, mapper.copy());
	}
	
	@Override
	protected String getTableName() {
		return "aluno";
	}
	
	public boolean checkIfExistsByCpf(String cpf) {
		System.out.println("CPF "+ cpf);
		return this.exists("data->'cpf'->>'numero' = ?","09393481954");
	}
	
	public Optional<Aluno> getByCpf(String cpf) {
		return this.findOne("data->'cpf'->>'numero' = ?", new SqlParameterValue(Types.VARCHAR, cpf));
	}

}