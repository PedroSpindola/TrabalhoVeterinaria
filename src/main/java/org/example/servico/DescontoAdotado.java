package org.example.servico;

import org.example.atendimento.AtendimentoDecorator;
import org.example.atendimento.IAtendimento;

public class DescontoAdotado extends AtendimentoDecorator
{

    private float serviceModifier;
    public DescontoAdotado(IAtendimento atendimento, float serviceModifier)
    {
        super(atendimento);
        this.serviceModifier = serviceModifier;
    }
    @Override
    public float getPercentualModificadorServico()
    {
        return 1-(serviceModifier/100);
    }
}
