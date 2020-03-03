package br.com.totvs.sistemaescolar.core.professor.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.sistemaescolar.core.professor.api.CriarProfessorCommand;
import br.com.totvs.sistemaescolar.core.professor.domain.model.Professor;
import br.com.totvs.sistemaescolar.core.professor.domain.model.ProfessorDomainRepository;
import br.com.totvs.sistemaescolar.core.professor.domain.model.ProfessorId;

@Service
public class ProfessorApplicationService {

	@Autowired
	ProfessorDomainRepository professorDomainRepository;

	public ProfessorId handle(final CriarProfessorCommand cmd) {
		ProfessorId professorId = cmd.getId() != null ? cmd.getId() : ProfessorId.generate();

		Professor professor = Professor.builder()
				.id(ProfessorId.generate())
				.nome(cmd.getNome())
				.email(cmd.getEmail())
				.cpf(cmd.getCpf())
				.titulo(cmd.getTitulo())
				.build();

		this.professorDomainRepository.insert(professor);
		return professor.getId();

	}
}
