package br.unibh.entidades;

import java.math.BigDecimal;

/**
 *
 * @author VictorVaz
 */
public class Professor 
{
    private BigDecimal salario;
    public static Double BONUS = 0.1D;
    
    @Override
    public String toString()
    {
        return "SALARIO = " + this.salario
             + ", BONUS = " + BONUS;
    }
}
