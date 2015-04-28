package br.unibh.escola.entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Table(name="PESSOA")
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa
{
	private Long id;
	@NotNull
	@Size(min=2, max=40)
	private String nome;
	@NotNull
	@Size(min=11, max=11)
	private String cpf;
	
	public Pessoa(Long id, String nome, String cpf)
	{
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	// Informa que o id será gerado pelo DB.
	@Column(name="id")
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	@Column(name="nome")
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	@Column(name="cpf")
	public String getCpf()
	{
		return cpf;
	}
	
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	@Override
	public String toString()
	{
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
}