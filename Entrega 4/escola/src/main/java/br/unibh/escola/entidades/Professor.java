package br.unibh.escola.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name="PROFESSOR")
public class Professor extends Pessoa
{
	@NotNull
	private BigDecimal salario;
	private static Double BONUS = 0.1D;
	
	public Professor(Long id, String nome, String cpf, BigDecimal salario)
	{
		super(id, nome, cpf);
		this.salario = salario;
	}

	@Column(name="salario")
	public BigDecimal getSalario()
	{
		return salario;
	}
	
	public void setSalario(BigDecimal salario)
	{
		this.salario = salario;
	}

	@Override
	public String toString()
	{
		return "Professor [salario=" + salario + ", bonus=" + BONUS + "]";
	}
}