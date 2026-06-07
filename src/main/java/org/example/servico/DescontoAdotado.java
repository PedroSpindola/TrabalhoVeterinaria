package org.example.servico;

import org.example.atendimento.AtendimentoDecorator;
import org.example.atendimento.IAtendimento;

public class DescontoAdotado extends AtendimentoDecorator {

    public DescontoAdotado(IAtendimento atendimento){
        super(atendimento);
    }
    @Override
    public float getPercentualAumentoServico() {
        return 15.0f;
    }
}
