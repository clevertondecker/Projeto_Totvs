package br.com.totvs.sistemaescolar.core.aluno.domain.model;



import java.util.Optional;

import com.totvs.tjf.repository.aggregate.AggregateRepository;

public interface AlunoDomainRepository extends AggregateRepository<Aluno, String> {

	boolean checkIfExistsByCpf(String cpf);
	
	Optional<Aluno> getByCpf(String cpf);

}
