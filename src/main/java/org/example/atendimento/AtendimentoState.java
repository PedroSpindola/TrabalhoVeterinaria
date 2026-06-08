package org.example.atendimento;

public abstract class AtendimentoState
{
    public abstract String getState();

    public boolean agendadoState(Atendimento atendimento){
        return false;
    }
    public boolean emAndamentoState(Atendimento atendimento){
        return false;
    }
    public boolean finalizadoState(Atendimento atendimento){
        return false;
    }
    public boolean canceladoState(Atendimento atendimento){
        return false;
    }
}
