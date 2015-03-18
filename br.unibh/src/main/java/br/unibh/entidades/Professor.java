package br.unibh.entidades;

import java.math.BigDecimal;

/**
 *
 * @author VictorVaz
 */
public class Professor extends Pessoa
{

    /**
     * @return the BONUS
     */
    public static Double getBONUS() {
        return BONUS;
    }

    /**
     * @param aBONUS the BONUS to set
     */
    public static void setBONUS(Double aBONUS) {
        BONUS = aBONUS;
    }
    
    private BigDecimal salario;
    private static Double BONUS = 0.1D;
    
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
        return "SALARIO = " + this.getSalario()
             + ", BONUS = " + getBONUS();
    }

    /**
     * @return the salario
     */
    public BigDecimal getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
