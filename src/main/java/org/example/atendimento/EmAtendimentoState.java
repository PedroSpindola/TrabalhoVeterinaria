package org.example.atendimento;

public class EmAtendimentoState extends AtendimentoState {
    private static EmAtendimentoState getInstance = new EmAtendimentoState();

    private EmAtendimentoState(){}

    public static EmAtendimentoState getInstance(){
        return getInstance;
    }

    @Override
    public boolean finalizadoState(Atendimento atendimento) {
        return true;
    }
}
