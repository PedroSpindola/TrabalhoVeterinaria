package AtendimentoStateTest;

import org.example.atendimento.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtendimentoStateTest
{
    Atendimento atendimento;

    @Test
    public void deveAprovarATrocaDeAgendadoParaCancelado(){
        atendimento = new Atendimento();
        assertTrue(atendimento.cancelar());
        assertEquals(CancelarState.getInstance(), atendimento.getEstado());
    }

    @Test
    public void naoDeveCancelarAtendimentoFinalizado(){
        atendimento = new Atendimento();
        assertTrue(atendimento.emAndamento());
        assertTrue(atendimento.finalizar());
        atendimento.cancelar();
        assertEquals(FinalizarState.getInstance(), atendimento.getEstado());
    }
}
