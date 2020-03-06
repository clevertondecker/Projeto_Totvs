package br.com.totvs.sistemaescolar.core.professor.application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.sistemaescolar.core.disciplina.domain.model.Disciplina;
import br.com.totvs.sistemaescolar.core.disciplina.domain.model.DisciplinaDomainRepository;
import br.com.totvs.sistemaescolar.core.pessoa.exception.VerificaCpfDuplicadoException;
import br.com.totvs.sistemaescolar.core.professor.api.CriarProfessorCommand;
import br.com.totvs.sistemaescolar.core.professor.domain.model.Professor;
import br.com.totvs.sistemaescolar.core.professor.domain.model.ProfessorDomainRepository;
import br.com.totvs.sistemaescolar.core.professor.domain.model.ProfessorId;

@Service
public class ProfessorApplicationService {

	@Autowired
	ProfessorDomainRepository professorRepository;
	
	@Autowired
	DisciplinaDomainRepository disciplinaRepository;

	public ProfessorId handle(final CriarProfessorCommand cmd) {
		ProfessorId professorId = cmd.getId() != null ? cmd.getId() : ProfessorId.generate();

		/* Valida CPF , comentado para testes*/
//		if (this.professorRepository.checkIfExistsByCpf(cmd.getCpf().getNumero())) {
//		throw new VerificaCpfDuplicadoException(cmd.getCpf().getNumero());
//	}
		Professor professor = Professor.builder()
				.id(professorId)
				.nome(cmd.getNome())
				.email(cmd.getEmail())
				.cpf(cmd.getCpf())
				.titulo(cmd.getTitulo())
				.build();
		
		//Recupera turma do banco de dados e adicionar o aluno.
		if(cmd.getDisciplinaId()!=null) {
 		Optional<Disciplina> optionalDisciplina = disciplinaRepository.getByDisciplinaId(cmd.getDisciplinaId().toString());
		System.out.println("Entrou");
 		optionalDisciplina.ifPresent(turma -> {

 			turma.adicionarProfessor(professorId);
			disciplinaRepository.update(turma);
		});
		}
		
		this.professorRepository.insert(professor);
		return professor.getId();

	}
}
