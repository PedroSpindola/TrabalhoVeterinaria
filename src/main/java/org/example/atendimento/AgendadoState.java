package org.example.atendimento;

public class AgendadoState extends AtendimentoState {
    private static AgendadoState getInstance = new AgendadoState();

    private AgendadoState(){}

    public static AgendadoState getInstance(){
        return getInstance;
    }

    @Override
    public String getState() {
        return "scheduled";
    }

    @Override
    public boolean emAndamentoState(Atendimento atendimento)
    {
        atendimento.setEstado(EmAtendimentoState.getInstance());
        return true;
    }

    @Override
    public boolean canceladoState(Atendimento atendimento)
    {
        atendimento.setEstado(CancelarState.getInstance());
        return true;
    }
}
