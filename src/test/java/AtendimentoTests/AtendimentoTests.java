package AtendimentoTests;

import org.example.atendimento.Atendimento;
import org.example.atendimento.IAtendimento;
import org.example.servico.DescontoAdotado;
import org.example.servico.ServicoBanho;
import org.example.servico.ServicoVacinacao;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtendimentoTests
{
    @Test
    public void deveRetornaOValorCorretoDoAtendimento(){
        IAtendimento atendimento = new DescontoAdotado(new ServicoBanho(new ServicoVacinacao( new Atendimento(1000), 10), 10), 10);
        assertEquals(1089.0f, atendimento.getValorServico(), 0.001f);
    }
}
