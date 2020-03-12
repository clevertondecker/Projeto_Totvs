package br.com.totvs.sistemaescolar.core.aluno.amqp.events;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@Builder
public final class AlunoCriadoEvent {

	public static final String NAME = "AlunoCriadoEvent";

	public static final String CONDITIONAL_EXPRESSION = "headers['type']=='" + NAME + "'";

	@Builder.Default
	private String origem = "sistema_escolar";

	@NotBlank(message = "{AlunoCriadoEvent.id.NotBlank}")
	private String id;

	@NotBlank(message = "{AlunoCriadoEvent.nome.NotBlank}")
	@Size(min = 3, max = 100, message = "{AlunoCriadoEvent.nome.Size}")
	private String nome;

	@NotBlank(message = "{AlunoCriadoEvent.email.NotBlank}")
	@Size(min = 3, max = 100, message = "{AlunoCriadoEvent.email.Size}")
	private String email;
	
	@NotBlank(message = "{AlunoCriadoEvent.cpf.NotBlank}")
	@Size(min = 11, max = 11, message = "{AlunoCriadoEvent.cpf.Size}")
	private String cpf;

	@NotBlank(message = "{AlunoCriadoEvent.matricula.NotBlank}")
	@Size(min = 1, max = 0, message = "{AlunoCriadoEvent.matricula.Size}")
	private String matricula;
	
	@NotBlank(message = "{AlunoCriadoEvent.formaIngresso.NotBlank}")
	@Size(min = 1, max = 10, message = "{AlunoCriadoEvent.formaIngresso.Size}")
	private String formaIngresso;
	
	private String turmaId;
	
}