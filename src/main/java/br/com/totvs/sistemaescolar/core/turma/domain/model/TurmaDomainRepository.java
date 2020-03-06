package br.com.totvs.sistemaescolar.core.turma.domain.model;


import com.totvs.tjf.repository.aggregate.AggregateRepository;

public interface TurmaDomainRepository extends AggregateRepository<Turma, String> {

	boolean checkIfExistsByDescricao(String descricao);

}
