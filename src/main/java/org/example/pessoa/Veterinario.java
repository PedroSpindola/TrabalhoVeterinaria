package org.example.pessoa;

import org.example.atendimento.Atendimento;

import java.util.Observable;
import java.util.Observer;

public class Veterinario extends Pessoa implements Observer, IFactory {

    private String crmv;
    private String ultNotificacao;

    public void setUltNotificacao(String ultNotificacao) {
        this.ultNotificacao = ultNotificacao;
    }
    public String getUltNotificacao() {
        return ultNotificacao;
    }
    public void addInteresseVaga(Atendimento interesse){
        interesse.addObserver(this);
    }
    @Override
    public void update(Observable vaga, Object arg) {
        this.ultNotificacao = " vaga Alterada:"+ vaga.toString();
    }

    @Override
    public Veterinario executarCriacao() {
        return new Veterinario();
    }
}
