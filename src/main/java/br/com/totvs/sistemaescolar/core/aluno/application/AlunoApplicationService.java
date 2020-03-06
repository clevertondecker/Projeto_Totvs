package br.com.totvs.sistemaescolar.core.aluno.application;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.sistemaescolar.core.aluno.api.CriarAlunoCommand;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.aluno.repository.AlunoRepository;


@Service
@Transactional
public class AlunoApplicationService {

	@Autowired
	AlunoRepository alunoRepository;
	

	public AlunoId handle(final CriarAlunoCommand cmd) {
		AlunoId alunoId = cmd.getId() != null ? cmd.getId() : AlunoId.generate();
				
		Aluno aluno = Aluno.builder()
				.id(alunoId)
				.nome(cmd.getNome())
				.email(cmd.getEmail())
				.cpf(cmd.getCpf())
				.formaIngresso(cmd.getFormaIngresso())
				.matricula(cmd.getMatricula())
				.build();
		
//		boolean cpfis = this.alunoRepository.exists(cmd.getCpf().getNumero());
//		System.out.println("RETURN CPF "+cpfis);
		
//		//Verificar porque nao encontra
		if (this.alunoRepository.checkIfExistsByCpf(cmd.getCpf().getNumero())) {
			System.out.println("chegou dentro do if");
		}
		
		this.alunoRepository.insert(aluno);
		return aluno.getId();

	}

}
