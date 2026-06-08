package org.example.atendimento;

import org.example.pessoa.Tutor;
import org.example.pessoa.Veterinario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Atendimento extends Observable implements IAtendimento {

    private LocalDate data;
    private LocalTime horario;
    private Tutor tutor;
    private Veterinario veterinario;
    private AtendimentoState estado;

    private Map<AtendimentoState, List<Observer>> _observadoresPorEstado = new HashMap<>();

    public void registrarObservador(AtendimentoState state, Observer user)
    {
        _observadoresPorEstado.putIfAbsent(state, new ArrayList<>());
        if (!_observadoresPorEstado.get(state).contains(user))
        {
            _observadoresPorEstado.get(state).add(user);
        }
    }

    public Atendimento(){
        this.estado = AgendadoState.getInstance();
        this.data = LocalDate.of(26,12,25);
        this.horario = LocalTime.of(12,59,59);
    }

    public Boolean agendar(){
        return estado.agendadoState(this);
    }
    public Boolean emAndamento()
    {
        Boolean transicaoSucesso = estado.emAndamentoState(this);
        if (transicaoSucesso) {
            notificar(this.estado);
        }
        return transicaoSucesso;
    }

    private void notificar(AtendimentoState estadoAtual) {
        List<Observer> interessados = _observadoresPorEstado.get(estadoAtual);

        if (interessados != null) {
            for (Observer observador : interessados) {
                observador.update(this, null);
            }
        }
    }
    public Boolean finalizar()
    {
        Boolean transicaoSucesso = estado.finalizadoState(this);
        if (transicaoSucesso) {
            notificar(this.estado);
        }
        return transicaoSucesso;
    }
    public Boolean cancelar()
    {
        Boolean transicaoSucesso = estado.canceladoState(this);
        if (transicaoSucesso) {
            notificar(this.estado);
        }
        return transicaoSucesso;
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
                "Data="+ this.data+
                ", Hora=" +this.horario+
                ", estado=" + estado.getState() +
                '}';
    }

}
