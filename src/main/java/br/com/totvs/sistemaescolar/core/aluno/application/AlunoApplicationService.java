package br.com.totvs.sistemaescolar.core.aluno.application;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totvs.sl.yms.core.porteiro.domain.model.Porteiro;
import com.totvs.sl.yms.core.porteiro.domain.model.PorteiroId;

import br.com.totvs.sistemaescolar.core.aluno.api.CriarAlunoCommand;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.aluno.repository.AlunoRepository;
import br.com.totvs.sistemaescolar.core.pessoa.exception.VerificaCpfDuplicadoException;
import br.com.totvs.sistemaescolar.core.turma.domain.model.Turma;
import br.com.totvs.sistemaescolar.core.turma.repository.TurmaRepository;

@Service
@Transactional
public class AlunoApplicationService {

	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	TurmaRepository turmaRepository;

	public AlunoId handle(final CriarAlunoCommand cmd) {
		AlunoId alunoId = cmd.getId() != null ? cmd.getId() : AlunoId.generate();

//		if (this.alunoRepository.checkIfExistsByCpf(cmd.getCpf().getNumero())) {
//		throw new VerificaCpfDuplicadoException(cmd.getCpf().getNumero());
//	}
		
		/*Cria aluno sem adicionar em nenhuma turma*/
		 Aluno aluno = Aluno.builder()
				.id(alunoId).nome(cmd.getNome())
				.email(cmd.getEmail())
				.cpf(cmd.getCpf())
				.formaIngresso(cmd.getFormaIngresso())
				.matricula(cmd.getMatricula())
				.build();
		 		
		 		System.out.println("Sem turma");
	 			 	
			 	//Recupera turma do banco de dados e adicionar o aluno.
				Optional<Turma> optionalTurma = turmaRepository.getByTurmaId(cmd.getTurmaId());
				System.out.println("COM TURMA");
				optionalTurma.ifPresent(turma -> {
					System.out.println("Presente");
					turma.adicionarAluno(alunoId);
					turmaRepository.update(turma);
				});
		
		this.alunoRepository.insert(aluno);
		return aluno.getId();

	}

	

}
