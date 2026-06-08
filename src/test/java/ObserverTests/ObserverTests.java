package ObserverTests;

import org.example.atendimento.Atendimento;
import org.example.pessoa.Tutor;
import org.example.pessoa.Veterinario;
import org.example.recepcao.Recepcao;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ObserverTests
{

    @Test
    public void deveNotificarOTutorQuandoIniciaOAtendimento(){
        Atendimento atendimento = new Atendimento();
        Tutor tutor = new Tutor();
        tutor.setNome("Patrick");
        tutor.addInteresseVaga(atendimento);
        atendimento.emAndamento();
        assertEquals("Atendimento Iniciado:Atendimento{Data=0026-12-25, Hora=12:59:59, estado=InProgress} Tutor:Patrick",tutor.getUltNotificacao());
    }

    @Test
    public void deveNotificarOVeterinarioQuandoCancelaOAtendimento(){
        Atendimento atendimento = new Atendimento();
        Veterinario veterinario = new Veterinario();
        Tutor tutor = new Tutor();
        veterinario.setNome("Jão");
        veterinario.addInteresseVaga(atendimento);
        atendimento.cancelar();
        assertEquals("Atendimento cancelado:Atendimento{Data=0026-12-25, Hora=12:59:59, estado=Canceled} Veterinario: Jão",veterinario.getUltNotificacao());
        assertNull(tutor.getUltNotificacao());
    }

    @Test
    public void deveNotificarARecepcaoETutorQuandoIniciaEFinalizaOAtendimento(){
        Atendimento atendimento = new Atendimento();
        Tutor tutor = new Tutor();
        tutor.setNome("Patrick");
        Recepcao recepcao = new Recepcao();
        tutor.addInteresseVaga(atendimento);
        recepcao.addInteresseVaga(atendimento);
        atendimento.emAndamento();
        atendimento.finalizar();
        assertEquals("Atendimento Iniciado:Atendimento{Data=0026-12-25, Hora=12:59:59, estado=InProgress} Tutor:Patrick",tutor.getUltNotificacao());
        assertEquals("Atendimento Finalizado: Atendimento{Data=0026-12-25, Hora=12:59:59, estado=Finalized}",recepcao.getUltNotificacao());
    }

    @Test
    public void naoDeveNotificarOVeterinarioQuandoNaoFoiCanceladoOAtendimento(){
        Atendimento atendimento = new Atendimento();
        Veterinario veterinario = new Veterinario();
        veterinario.setNome("Jão");
        atendimento.emAndamento();
        veterinario.addInteresseVaga(atendimento);
        assertNull(veterinario.getUltNotificacao());
    }
}
