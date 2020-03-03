package br.com.totvs.sistemaescolar.core.professor.domain.model;

import java.util.UUID;

import org.springframework.util.Assert;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class ProfessorId {

	private UUID id;

	private ProfessorId(UUID id) {
		Assert.notNull(id, "Id should not be null.");
		this.id = id;
	}

	public static ProfessorId generate() {
		return new ProfessorId(UUID.randomUUID());
	}

	public static ProfessorId fromString(String value) {
		return new ProfessorId(UUID.fromString(value));
	}

	@Override
	public String toString() {
		return id.toString();
	}
}