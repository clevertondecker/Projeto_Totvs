package br.com.totvs.sistemaescolar.core.aluno.api;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.aluno.enums.formaDeIngresso;
import lombok.Getter;

@Getter
public class CriarAlunoCommandDto {

	private AlunoId id;

	@NotNull(message = "{AdicionarAlunoCommandDto.matricula.NotNull}")
	private Long matricula;

	@NotNull(message = "{AdicionarAlunoCommandDto.formaDeIngresso.NotNull}")
	private formaDeIngresso formaIngresso;

	@NotNull(message = "{AdicionarAlunoCommandDto.nome.NotNull}")
	@Size(min = 2, max = 25, message = "{CriarChegadaAgendadaCommandDto.nome.Size}")
	private String nome;

	@NotNull(message = "{AdicionarAlunoCommandDto.email.NotNull}")
	@Email(message = "{AdicionarAlunoCommandDto.email.Emailinvalido}")
	private String email;

	@Valid
	private CpfCommandDto cpf;

}
