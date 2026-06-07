package org.example.atendimento;

import org.example.pessoa.Tutor;
import org.example.pessoa.Veterinario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Observable;

public class Atendimento extends Observable implements IAtendimento {

    private LocalDate data;
    private LocalTime horario;
    private Tutor tutor;
    private Veterinario veterinario;
    private AtendimentoState estado;

    public Atendimento(){
        this.estado = AgendadoState.getInstance();
    }

    public Boolean agendar(){
        return estado.agendadoState(this);
    }
    public Boolean emAndamento(){
        return estado.emAndamentoState(this);
    }
    public Boolean finalizar(){
        return estado.finalizadoState(this);
    }
    public Boolean cancelar(){
        return estado.canceladoState(this);
    }

    public AtendimentoState getEstado() {
        return estado;
    }
    public void setEstado(AtendimentoState estado) {
        this.estado = estado;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
    public Tutor getTutor() {
        return tutor;
    }
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    public Veterinario getVeterinario() {
        return veterinario;
    }
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    @Override
    public float getValorServico() {
        return 0;
    }
    public void avisarVaga() {
        setChanged();
        notifyObservers();
    }
    @Override
    public String toString() {

        return "Atendimento{" +
                "data=" + data +
                ", horario=" + horario +
                ", tutor=" + tutor.getNome() +
                ", veterinario=" + veterinario.getNome() +
                ", estado=" + getEstado() +
                '}';
    }

}
