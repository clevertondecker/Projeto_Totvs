package br.com.totvs.sistemaescolar.core.disciplina.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.sistemaescolar.core.disciplina.api.CriarDisciplinaCommand;
import br.com.totvs.sistemaescolar.core.disciplina.domain.model.Disciplina;
import br.com.totvs.sistemaescolar.core.disciplina.domain.model.DisciplinaDomainRepository;
import br.com.totvs.sistemaescolar.core.disciplina.domain.model.DisciplinaId;

@Service
public class DisciplinaApplicationService {

	@Autowired
	DisciplinaDomainRepository disciplinaDomainRepository;

	public DisciplinaId handle(final CriarDisciplinaCommand cmd) {

		Disciplina disciplina = Disciplina.builder()
				.id(DisciplinaId.generate())
				.descricao(cmd.getDescricao())
				.sigla(cmd.getSigla())
				.cargaHoraria(cmd.getCargaHoraria())
//				.professor(cmd.getProfessor())
//				.turma(cmd.getTurma())
				.build();
		
		
		this.disciplinaDomainRepository.insert(disciplina);
		return disciplina.getId();

	}

}