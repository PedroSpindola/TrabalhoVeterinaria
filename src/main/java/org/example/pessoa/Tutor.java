package org.example.pessoa;

import org.example.animal.Animal;
import org.example.atendimento.Atendimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Tutor extends Pessoa implements Observer {

    private List<Animal> pet = new ArrayList<Animal>();
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

}
