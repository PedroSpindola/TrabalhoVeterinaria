package org.example.pessoa;

import org.example.atendimento.Atendimento;
import org.example.atendimento.CancelarState;
import org.example.atendimento.EmAtendimentoState;

import java.util.Observable;
import java.util.Observer;

public class Veterinario extends Pessoa implements Observer {

    private String crmv;
    private String ultNotificacao;

    public void setUltNotificacao(String ultNotificacao) {
        this.ultNotificacao = ultNotificacao;
    }
    public String getUltNotificacao() {
        return ultNotificacao;
    }
    public void addInteresseVaga(Atendimento interesse)
    {
        interesse.registrarObservador(CancelarState.getInstance(), this);
    }
    @Override
    public void update(Observable vaga, Object arg)
    {
        this.ultNotificacao = "Atendimento cancelado:"+ vaga.toString()+" Veterinario: "+ this.getNome();
    }

}
