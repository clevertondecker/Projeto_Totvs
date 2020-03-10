package br.com.totvs.sistemaescolar.core.aluno.amqp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.totvs.tjf.core.message.TOTVSMessage;
import com.totvs.tjf.core.validation.ValidatorService;

import br.com.totvs.sistemaescolar.core.aluno.amqp.events.AlunoCriadoEvent;
import br.com.totvs.sistemaescolar.core.aluno.api.CriarAlunoCommand;
import br.com.totvs.sistemaescolar.core.aluno.application.AlunoApplicationService;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.aluno.enums.formaDeIngresso;
import br.com.totvs.sistemaescolar.core.aluno.exception.AlunoJaExisteException;
import br.com.totvs.sistemaescolar.core.amqp.SistemaEscolaExchangeInput;
import br.com.totvs.sistemaescolar.core.config.RACExchange;
import br.com.totvs.sistemaescolar.core.pessoa.domain.model.CPF;
import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaId;

@EnableBinding(SistemaEscolaExchangeInput.class)
public class AlunoSubscriber {

	private AlunoApplicationService alunoAppService;

	private ValidatorService validatorService;

	public AlunoSubscriber(AlunoApplicationService alunoAppService, ValidatorService validatorService) {
		this.alunoAppService = alunoAppService;
		this.validatorService = validatorService;
	}

	@StreamListener(target = SistemaEscolaExchangeInput.INPUT, condition = AlunoCriadoEvent.CONDITIONAL_EXPRESSION)
	public void alunoCriadoEvent(TOTVSMessage<AlunoCriadoEvent> event) {

		AlunoCriadoEvent content = event.getContent();
		
		System.out.println("event.getContent() "+event.getContent());

		if (!content.getOrigem().equals("sistema_escolar")) {

			validatorService.validate(content).ifPresent(violations -> {
				throw new AlunoJaExisteException(violations);
			});

				//Corrigir forma de ingresso e matricula
			var cmd = CriarAlunoCommand.fromIntegration(AlunoId.fromString(content.getId()), content.getNome(),
					content.getEmail(),CPF.of(content.getCpf()), formaDeIngresso.ENADE,23434L,TurmaId.fromString(content.getTurmaId()));

			alunoAppService.handle(cmd);
		}
	}
}
