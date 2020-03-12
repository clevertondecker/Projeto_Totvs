package br.com.totvs.sistemaescolar.core.professor.amqp.events;

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
public class ProfessorCriadoEvent {

		public static final String NAME = "ProfessorCriadoEvent";

		public static final String CONDITIONAL_EXPRESSION = "headers['type']=='" + NAME + "'";

		@Builder.Default
		private String origem = "sistema_escolar";

		@NotBlank(message = "{ProfessorCriadoEvent.id.NotBlank}")
		private String id;

		@NotBlank(message = "{ProfessorCriadoEvent.nome.NotBlank}")
		@Size(min = 3, max = 100, message = "{ProfessorCriadoEvent.nome.Size}")
		private String nome;

		@NotBlank(message = "{ProfessorCriadoEvent.email.NotBlank}")
		@Size(min = 3, max = 100, message = "{ProfessorCriadoEvent.email.Size}")
		private String email;
		
		@NotBlank(message = "{ProfessorCriadoEvent.cpf.NotBlank}")
		@Size(min = 11, max = 11, message = "{ProfessorCriadoEvent.cpf.Size}")
		private String cpf;

		@NotBlank(message = "{ProfessorCriadoEvent.titulo.NotBlank}")
		@Size(min = 11, max = 11, message = "{ProfessorCriadoEvent.titulo.Size}")
		private String titulo;
		
		private String disciplinaId;
		
	}