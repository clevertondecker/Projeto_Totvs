package br.com.totvs.sistemaescolar.core.professor.domain.model;


import com.totvs.tjf.repository.aggregate.AggregateRepository;

public interface ProfessorDomainRepository extends AggregateRepository<Professor, String> {

	boolean checkIfExistsByCpf(String cpf);

}
