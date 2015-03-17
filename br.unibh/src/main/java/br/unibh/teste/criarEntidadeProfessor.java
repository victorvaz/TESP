package br.unibh.teste;

import br.unibh.entidades.Professor;
import java.math.BigDecimal;

/**
 *
 * @author VictorVaz
 */
public class criarEntidadeProfessor
{
    public static void main(String[] args)
    {
        Professor cProfessor = new Professor((long) 1, "José", "12312312312", BigDecimal.valueOf(4000.00));
    }
}
