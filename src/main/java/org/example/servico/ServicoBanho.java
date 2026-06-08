package org.example.servico;

import org.example.atendimento.AtendimentoDecorator;
import org.example.atendimento.IAtendimento;

public class ServicoBanho extends AtendimentoDecorator implements IServico
{
    private float serviceModifier;

    public ServicoBanho(IAtendimento atendimento, float serviceModifier)
    {
        super(atendimento);
        this.serviceModifier = serviceModifier;
    }

    @Override
    public float getPercentualModificadorServico()
    {
        return 1+(serviceModifier/100);
    }
}
