package org.example.pessoa;

public class Funcionario extends Pessoa implements IFactory {
    @Override
    public Funcionario executarCriacao() {
        return new Funcionario();
    }
}
