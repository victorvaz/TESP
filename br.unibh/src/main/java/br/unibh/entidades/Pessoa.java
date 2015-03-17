package br.unibh.entidades;

/**
 *
 * @author VictorVaz
 */
public class Pessoa
{
    private Long id;
    private String nome;
    private String cpf;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString()
    {
        return "ID = " + this.id
             + ",NOME = " + this.nome
             + ",CPF = " + this.cpf + ".";
    }
}