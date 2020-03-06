package br.com.totvs.sistemaescolar.core.disciplina.domain.model;

import java.util.Optional;

import com.totvs.tjf.repository.aggregate.AggregateRepository;

public interface DisciplinaDomainRepository extends AggregateRepository<Disciplina, String> {

	Optional<Disciplina> getByDisciplinaId(String disciplinaId);

}
