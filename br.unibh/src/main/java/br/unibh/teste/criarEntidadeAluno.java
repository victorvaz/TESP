package br.unibh.teste;

import br.unibh.entidades.Aluno;
import java.util.Date;

/**
 *
 * @author VictorVaz
 */
public class criarEntidadeAluno
{
    public static void main (String[] args)
    {
        Aluno cAluno = new Aluno((long) 1, "Víctor Vaz", "11855074699", (long)11312400, new Date());
    }
}
