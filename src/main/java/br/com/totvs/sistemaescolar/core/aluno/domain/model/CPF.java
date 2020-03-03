package br.com.totvs.sistemaescolar.core.aluno.domain.model;

import javax.validation.constraints.NotNull;

import br.com.totvs.sistemaescolar.core.aluno.exception.CpfDeveSerValidoException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CPF {

	@NotNull
	private String numero;

	private CPF(String numero) {
		if (isInvalid(numero))
			throw new CpfDeveSerValidoException();
		this.numero = numero;
	}

	public static CPF of(String numero) {
		return new CPF(numero);
	}


	private boolean isInvalid(String cpf) {
		return !isValid(cpf);
	}

	private boolean isValid(String cpf) {

		try {
			// Aceitar números de CPF no seguinte formato: 00000000000
			if (!cpf.isBlank() && cpf.matches("[0-9]{11}")) {
				String primeiroCaractere = cpf.substring(0, 1); // Busca o primeiro caractere
				String removerRepeticoes = cpf.replaceAll(primeiroCaractere, ""); // Remove as repetições do

				return verificarCPF(removerRepeticoes, cpf);
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean verificarCPF( String numeroSemRepeticoes, String cpf) {
		if (numeroSemRepeticoes.length() > 0) {

			int somatorio1 = 0;
			int somatorio2 = 0;
			int peso1 = 10;
			int peso2 = 11;
			int numeracao;

			String[] vetorCPF = cpf.split("");

			for (int i = 0; i < 10; i++) {

				numeracao = Integer.parseInt(vetorCPF[i]); // Transforma o elemento do vetor em um número
				// inteiro para ser multiplicado

				somatorio1 = (i < 9) ? somatorio1 + (numeracao * peso1) : somatorio1; // Realiza o somatório
				// para o primeiro
				// digito verificador,
				// utilizando somente os
				// 9 primeiros dígitos

				somatorio2 = somatorio2 + (numeracao * peso2); // Realiza o somatório para o segundo digito
				// verificador

				peso1--; // Subtrai 1 do peso para o primeiro digito verificador

				peso2--; // Subtrai 1 do peso para o segundo digito verificador
			}

			int valor1 = 11 - (somatorio1 % 11); // Subtrai o resto da divisão inteira do primeiro somatório
			// por 11, de 11.
			int valor2 = 11 - (somatorio2 % 11); // Subtrai o resto da divisão inteira do segundo somatório
			// por 11, de 11.

			int digitoVerificador1 = (valor1 > 9) ? 0 : valor1; // Substitui por 0 se o valor maior que 9.
			int digitoVerificador2 = (valor2 > 9) ? 0 : valor2; // Substitui por 0 se o valor maior que 9.

			// É importante transformar o valor do elemento do vetor em um inteiro antes de
			// se fazer a comparação
			return Integer.parseInt(vetorCPF[9]) == digitoVerificador1
					&& Integer.parseInt(vetorCPF[10]) == digitoVerificador2;
		}
		return false;
	}
}
