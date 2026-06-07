package org.example.atendimento;

public abstract class AtendimentoDecorator implements IAtendimento {
    private IAtendimento atendimento;

    public AtendimentoDecorator(IAtendimento atendimento){
        this.atendimento = atendimento;
    }
    public IAtendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(IAtendimento atendimento) {
        this.atendimento = atendimento;
    }

    public abstract float getPercentualAumentoServico();

    public float getValorServico() {
        return this.atendimento.getValorServico() *(1+this.getPercentualAumentoServico()/100);
    }
}
