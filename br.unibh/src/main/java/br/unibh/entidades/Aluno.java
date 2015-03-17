package br.unibh.entidades;

import java.util.Date;

/**
 *
 * @author VictorVaz
 */
public class Aluno
{
    private Long matricula;
    private Date dataAniversario;

    /**
     * @return the matricula
     */
    public Long getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the dataAniversario
     */
    public Date getDataAniversario() {
        return dataAniversario;
    }

    /**
     * @param dataAniversario the dataAniversario to set
     */
    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
    
    @Override
    public String toString()
    {
        return "MATRICULA = " + this.matricula
             + "DATA ANIVERSARIO = " + this.dataAniversario;
    }
}
