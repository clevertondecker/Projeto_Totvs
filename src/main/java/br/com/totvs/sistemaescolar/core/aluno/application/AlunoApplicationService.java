package br.com.totvs.sistemaescolar.core.aluno.application;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.sistemaescolar.core.aluno.amqp.events.AlunoCriadoEvent;
import br.com.totvs.sistemaescolar.core.aluno.api.CriarAlunoCommand;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.aluno.repository.AlunoRepository;
import br.com.totvs.sistemaescolar.core.amqp.SistemaEscolaPublisher;
import br.com.totvs.sistemaescolar.core.turma.domain.model.Turma;
import br.com.totvs.sistemaescolar.core.turma.repository.TurmaRepository;

@Service
@Transactional
public class AlunoApplicationService {

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	TurmaRepository turmaRepository;

	@Autowired
	private SistemaEscolaPublisher sistemaEscolaPublisher;

	public AlunoId handle(final CriarAlunoCommand cmd) {
		AlunoId alunoId = cmd.getId() != null ? cmd.getId() : AlunoId.generate();
				
		/* Valida CPF , comentado para testes */
//		if (this.alunoRepository.checkIfExistsByCpf(cmd.getCpf().getNumero())) {
//		throw new VerificaCpfDuplicadoException(cmd.getCpf().getNumero());
//	}

		/* Cria aluno sem adicionar em nenhuma turma */
		Aluno aluno = Aluno.builder().id(alunoId).nome(cmd.getNome()).email(cmd.getEmail()).cpf(cmd.getCpf())
				.formaIngresso(cmd.getFormaIngresso()).matricula(cmd.getMatricula()).build();

		/* Recupera a turma do banco de dados para adicionar o novo aluno. */
		if (cmd.getTurmaId() != null) {
			Optional<Turma> optionalTurma = turmaRepository.getByTurmaId(cmd.getTurmaId().toString());
			
			optionalTurma.ifPresent(turma -> {
				System.out.println("Presente");
				turma.adicionarAluno(alunoId);
				turmaRepository.update(turma);
			});
		}

		this.alunoRepository.insert(aluno);
		
		/* Publica aluno no evento.*/
		sistemaEscolaPublisher.publish(AlunoCriadoEvent.builder()
				.id(aluno.getId().toString())
				.nome(aluno.getNome())
				.email(aluno.getEmail())
				.cpf(aluno.getCpf().toString())
				.matricula(aluno.getMatricula().toString())
				.formaIngresso(aluno.getFormaIngresso().toString())
				.turmaId(cmd.getTurmaId().toString())
				.build());
		
		return aluno.getId();

	}

}
