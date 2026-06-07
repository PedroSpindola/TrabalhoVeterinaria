package org.example.atendimento;

public class FinalizarState extends AtendimentoState {
    private static FinalizarState getInstance = new FinalizarState();

    private FinalizarState(){}

    public static FinalizarState getInstance(){
        return getInstance;
    }
}
