package org.example.servico;

import org.example.atendimento.AtendimentoDecorator;
import org.example.atendimento.IAtendimento;

public class TaxaDomiciliar extends AtendimentoDecorator {

    public TaxaDomiciliar(IAtendimento atendimento){
        super(atendimento);
    }
    @Override
    public float getPercentualAumentoServico() {
        return 10.0f;
    }
}
