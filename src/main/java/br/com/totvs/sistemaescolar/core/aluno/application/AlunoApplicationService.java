package br.com.totvs.sistemaescolar.core.aluno.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.sistemaescolar.core.aluno.api.CriarAlunoCommand;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoDomainRepository;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;

@Service
public class AlunoApplicationService {

	@Autowired
	AlunoDomainRepository alunoDomainRepository;

	public AlunoId handle(final CriarAlunoCommand cmd) {
		AlunoId alunoId = cmd.getId() != null ? cmd.getId() : AlunoId.generate();

		Aluno aluno = Aluno.builder()
				.id(AlunoId.generate())
				.nome(cmd.getNome())
				.email(cmd.getEmail())
				.cpf(cmd.getCpf())
				.formaIngresso(cmd.getFormaIngresso())
				.matricula(cmd.getMatricula())
				.build();

		this.alunoDomainRepository.insert(aluno);
		return aluno.getId();

	}

}
