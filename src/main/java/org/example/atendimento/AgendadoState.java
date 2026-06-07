package org.example.atendimento;

public class AgendadoState extends AtendimentoState {
    private static AgendadoState getInstance = new AgendadoState();

    private AgendadoState(){}

    public static AgendadoState getInstance(){
        return getInstance;
    }

    @Override
    public boolean emAndamentoState(Atendimento atendimento) {
        return true;
    }

    @Override
    public boolean canceladoState(Atendimento atendimento) {
        return true;
    }
}
