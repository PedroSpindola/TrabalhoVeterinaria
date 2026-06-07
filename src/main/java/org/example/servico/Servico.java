package org.example.servico;

import org.example.atendimento.IAtendimento;

public abstract class Servico implements IAtendimento {
    private float valorServico;

    public Servico(float valorServico){
        this.valorServico = valorServico;
    }

    public float getValorServico() {
        return valorServico;
    }
}
