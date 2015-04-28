package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="ALUNO")
public class Aluno extends Pessoa
{
	@NotNull
	private Long matricula;
	@Past
	private Date dataAniversario;
	
	public Aluno(Long id, String nome, String cpf, Long matricula, Date dataAniversario)
	{
		super(id, nome, cpf);
		this.matricula = matricula;
		this.dataAniversario = dataAniversario;
	}

	@Column(name="matricula")
	public Long getMatricula()
	{
		return matricula;
	}
	
	public void setMatricula(Long matricula)
	{
		this.matricula = matricula;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_aniversario")
	public Date getDataAniversario()
	{
		return dataAniversario;
	}
	
	public void setDataAniversario(Date dataAniversario)
	{
		this.dataAniversario = dataAniversario;
	}

	@Override
	public String toString()
	{
		return "Aluno [matricula=" + matricula + ", dataAniversario=" + dataAniversario + "]";
	}
}