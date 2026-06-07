package org.example.atendimento;

public class CancelarState extends AtendimentoState{
    private static CancelarState getInstance = new CancelarState();

    private CancelarState(){}

    public static CancelarState getInstance(){
        return getInstance;
    }
}
