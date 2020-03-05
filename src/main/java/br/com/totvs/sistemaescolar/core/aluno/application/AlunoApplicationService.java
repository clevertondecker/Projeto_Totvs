package br.com.totvs.sistemaescolar.core.aluno.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.sistemaescolar.core.aluno.api.CriarAlunoCommand;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoDomainRepository;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.pessoa.exception.VerificaCpfDuplicadoException;

@Service
public class AlunoApplicationService {

	@Autowired
	AlunoDomainRepository alunoDomainRepository;

	public AlunoId handle(final CriarAlunoCommand cmd) {

		Aluno aluno = Aluno.builder()
				.id(AlunoId.generate())
				.nome(cmd.getNome())
				.email(cmd.getEmail())
				.cpf(cmd.getCpf())
				.formaIngresso(cmd.getFormaIngresso())
				.matricula(cmd.getMatricula())
				.turmaId(cmd.getTurmaId())
				.build();
		
		//Verificar porque nao encontra
		if (this.alunoDomainRepository.checkIfExistsByCpf(cmd.getCpf().getNumero()))
			throw new VerificaCpfDuplicadoException(cmd.getCpf().getNumero());

		boolean cpfis = this.alunoDomainRepository.exists(cmd.getCpf().getNumero());
		System.out.println(cpfis);
		
		this.alunoDomainRepository.insert(aluno);
		return aluno.getId();

	}

}
