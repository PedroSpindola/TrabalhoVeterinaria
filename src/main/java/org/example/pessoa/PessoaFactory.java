package org.example.pessoa;

public class PessoaFactory {
    private static PessoaFactory instance = new PessoaFactory();

    private PessoaFactory(){}

    public static PessoaFactory getInstance() {
        return instance;
    }

    public static Pessoa obterPessoa(String pessoa){
        Class classe = null;
        Object object = null;

        try{
            classe = Class.forName("org.example.pessoa." + pessoa);
            object = classe.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Pessoa inexistente");
        }
        if (!(object instanceof Pessoa)){
            throw new IllegalArgumentException("Pessoa inválido");
        }
        return (Pessoa) object;
    }

}
