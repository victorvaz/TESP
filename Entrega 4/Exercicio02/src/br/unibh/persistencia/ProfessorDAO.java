package br.unibh.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unibh.entidades.Professor;

public class ProfessorDAO implements DAO<Professor, Integer>
{
	@Override
	public Professor find(Integer id) throws SQLException, Exception
	{
		String sql = "SELECT id,"
				   + "       nome,"
				   + "       cpf,"
				   + "       salario"
				   + "  FROM PROFESSOR"
				   + " WHERE id = ?";
		
		PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(sql);
		p.setLong(1, id);
		
		ResultSet r = p.executeQuery();
		
		while (r.next())
		{
			Professor professor = new Professor(r.getLong("id"), r.getString("nome"), r.getString("cpf"), r.getBigDecimal("salario"));
			return professor;
		}
		
		return null;
	}

	@Override
	public void insert(Professor t) throws SQLException, Exception
	{
		String sql = "INSERT INTO PROFESSOR (nome,"
				   + "                       cpf,"
				   + "                       salario)"
				   + "               VALUES (?,"
				   + "                       ?,"
				   + "                       ?)";
		
		PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(sql);
		p.setString(1, t.getNome());
		p.setString(2, t.getCpf());
		p.setBigDecimal(3, t.getSalario());
		
		p.executeQuery();
	}

	@Override
	public void update(Professor t) throws SQLException, Exception
	{
		String sql = "UPDATE PROFESSOR"
				   + "   SET nome = ?,"
				   + "       cpf = ?,"
				   + "       salario = ?"
				   + " WHERE id = ?";
		
		PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(sql);
		p.setString(1, t.getNome());
		p.setString(2, t.getCpf());
		p.setBigDecimal(3, t.getSalario());
		p.setLong(4, t.getId());
		
		p.executeQuery();
	}

	@Override
	public void delete(Integer id) throws SQLException, Exception
	{
		String sql = "DELETE FROM PROFESSOR"
				   + "      WHERE id = ?";
		
		PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(sql);
		p.setLong(1, id);
		
		p.executeQuery();
	}

	@Override
	public List<Professor> findAll() throws SQLException, Exception
	{
		String sql = "SELECT id,"
				   + "       nome,"
				   + "       cpf,"
				   + "       salario"
				   + "  FROM PROFESSOR";
		
		PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(sql);		
		ResultSet r = p.executeQuery();
		
		List<Professor> ListaProfessores = new ArrayList<>();
		
		while (r.next())
		{
			Professor professor = new Professor(r.getLong("id"), r.getString("nome"), r.getString("cpf"), r.getBigDecimal("salario"));
			ListaProfessores.add(professor);
		}
		
		return ListaProfessores;
	}
}