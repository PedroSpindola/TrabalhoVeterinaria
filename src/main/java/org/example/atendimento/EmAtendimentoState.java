package org.example.atendimento;

public class EmAtendimentoState extends AtendimentoState {
    private static EmAtendimentoState getInstance = new EmAtendimentoState();

    private EmAtendimentoState(){}

    public static EmAtendimentoState getInstance(){
        return getInstance;
    }

    @Override
    public String getState() {
        return "InProgress";
    }

    @Override
    public boolean finalizadoState(Atendimento atendimento)
    {
        atendimento.setEstado(FinalizarState.getInstance());
        return true;
    }
}
