package org.example.recepcao;

import org.example.atendimento.Atendimento;
import org.example.atendimento.EmAtendimentoState;
import org.example.atendimento.FinalizarState;

import java.util.Observable;
import java.util.Observer;

public class Recepcao implements Observer{
    private String ultNotificacao;

    public void setUltNotificacao(String ultNotificacao) {
        this.ultNotificacao = ultNotificacao;
    }
    public String getUltNotificacao() {
        return ultNotificacao;
    }
    public void addInteresseVaga(Atendimento interesse)
    {
        interesse.registrarObservador(FinalizarState.getInstance(), this);
    }
    @Override
    public void update(Observable vaga, Object arg)
    {
        this.ultNotificacao = "Atendimento Finalizado: "+ vaga.toString();
    }
}
