package br.com.totvs.sistemaescolar.core.turma.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoDomainRepository;
import br.com.totvs.sistemaescolar.core.turma.api.CriarTurmaCommand;
import br.com.totvs.sistemaescolar.core.turma.domain.model.Turma;
import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaDomainRepository;
import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaId;

@Service
public class TurmaApplicationService {

	@Autowired
	TurmaDomainRepository turmaDomainRepository;
	
	@Autowired
	AlunoDomainRepository alunoDomainRepository;

	public TurmaId handle(final CriarTurmaCommand cmd) {
		
		Turma turma = Turma.builder()
				.id(TurmaId.generate())
				.descricao(cmd.getDecricao())
				.anoLetivo(cmd.getAnoLetivo())
				.periodoLetivo(cmd.getPeriodoLetivo())
				.numeroVagas(cmd.getNumeroVagas())
				.alunoId(cmd.getAlunoId())
				.disciplinaId(cmd.getDisciplinaId())
				.build();

		this.turmaDomainRepository.insert(turma);
		return turma.getId();
	}

}
