package br.com.totvs.sistemaescolar.core.professor.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.totvs.sistemaescolar.core.disciplina.domain.model.DisciplinaId;
import br.com.totvs.sistemaescolar.core.pessoa.exception.CpfCommandDto;
import br.com.totvs.sistemaescolar.core.professor.domain.model.ProfessorId;
import br.com.totvs.sistemaescolar.core.professor.enums.Titulacao;
import lombok.Getter;

@Getter
public class CriarProfessorCommandDto {

	private ProfessorId id;

	@NotNull(message = "{AdicionarProfessorCommandDto.nome.NotNull}")
	@Size(min = 2, max = 25, message = "{CriarProfessorCommandDto.nome.Size}")
	private String nome;

	@NotNull(message = "{AdicionarProfessorCommandDto.email.NotNull}")
	@Email(message = "{AdicionarProfessorCommandDto.email.Emailinvalido}")
	private String email;

	@Valid
	private CpfCommandDto cpf;

	@NotNull(message = "{AdicionarProfessorCommandDto.titulo.NotNull}")
	private Titulacao titulo;
	
	private List<DisciplinaId> disciplinasId;

}