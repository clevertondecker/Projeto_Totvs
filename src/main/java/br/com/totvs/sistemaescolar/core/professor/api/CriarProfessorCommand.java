package br.com.totvs.sistemaescolar.core.professor.api;


import br.com.totvs.sistemaescolar.core.disciplina.domain.model.DisciplinaId;
import br.com.totvs.sistemaescolar.core.pessoa.domain.model.CPF;
import br.com.totvs.sistemaescolar.core.professor.domain.model.ProfessorId;
import br.com.totvs.sistemaescolar.core.professor.enums.Titulacao;
import lombok.Data;

@Data(staticConstructor = "of")
public class CriarProfessorCommand {

	private final ProfessorId id;
	private final String nome;
	private final String email;
	private final CPF cpf;
	private final Titulacao titulo;
	private final DisciplinaId disciplinaId;

	public static CriarProfessorCommand of(String nome, String email, CPF cpf, Titulacao titulo,
			DisciplinaId disciplinaId) {
		return new CriarProfessorCommand(null, nome, email, cpf, titulo,disciplinaId);
	}

}
