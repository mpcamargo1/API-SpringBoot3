package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsultas {

    public void validar(DadosAgendamentoConsulta dados) {
        LocalDateTime dataConsulta = dados.data();

        boolean domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        boolean antesDaAberturaClinica = dataConsulta.getHour() < 7;
        boolean depoisDoEncerramento = dataConsulta.getHour() > 18;

        if (domingo || antesDaAberturaClinica || depoisDoEncerramento) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }



    }
}
