package br.unibh.entidades;

import java.math.BigDecimal;

/**
 *
 * @author VictorVaz
 */
public class Professor extends Pessoa
{
    private BigDecimal salario;
    public static Double BONUS = 0.1D;
    
    public Professor()
    {
        
    }

    public Professor(Long id, String nome, String cpf, BigDecimal salario)
    {
        super.setId(id);
        super.setNome(nome);
        super.setCpf(cpf);
        this.salario = salario;
    }
                
    @Override
    public String toString()
    {
        return "SALARIO = " + this.salario
             + ", BONUS = " + BONUS;
    }
}
