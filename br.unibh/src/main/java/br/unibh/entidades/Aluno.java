package br.unibh.entidades;

import java.util.Date;

/**
 *
 * @author VictorVaz
 */
public class Aluno extends Pessoa
{
    private Long matricula;
    private Date dataAniversario;
    
    public Aluno()
    {
    }

    public Aluno(Long id, String nome, String cpf, Long matricula, Date dataAniversario)
    {
        super.setId(id);
        super.setNome(nome);
        super.setCpf(cpf);
        this.matricula = matricula;
        this.dataAniversario = dataAniversario;
    }
    

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
