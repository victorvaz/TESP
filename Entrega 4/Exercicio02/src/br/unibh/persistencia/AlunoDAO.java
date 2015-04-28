package br.unibh.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.unibh.entidades.Aluno;

public class AlunoDAO implements DAO<Aluno, Integer>
{
	private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public Aluno find(Integer id) throws SQLException, Exception
	{
		String sql = "SELECT id,"
				   + "       nome,"
				   + "       cpf,"
				   + "       matricula,"
				   + "       data_aniversario"
				   + "  FROM ALUNO"
				   + " WHERE id = ?";
		
		PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(sql);
		p.setLong(1, id);
		
		ResultSet r = p.executeQuery();
		
		if (r.next())
		{
			Aluno aluno = new Aluno(r.getLong("id"), r.getString("nome"), r.getString("cpf"), r.getLong("matricula"), r.getDate("data_aniversario"));
			return aluno;
		}
		
		return null;
	}

	@Override
	public void insert(Aluno t) throws SQLException, Exception
	{
		String sql = "INSERT INTO ALUNO (nome,"
				   + "                   cpf,"
				   + "                   matricula,"
				   + "                   data_aniversario)"
				   + "                  (?,"
				   + "                   ?,"
				   + "                   ?,"
				   + "                   ?)";
		
		
		PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(sql);
		p.setString(1, t.getNome());
		p.setString(2, t.getCpf());
		p.setLong(3, t.getMatricula());
		p.setString(4, df.format(t.getDataAniversario()));
		
		p.executeQuery();
	}

	@Override
	public void update(Aluno t) throws SQLException, Exception
	{
		String sql = "UPDATE ALUNO"
				   + "   SET nome = ?,"
				   + "       cpf = ?,"
				   + "       matricula = ?,"
				   + "       data_aniversario = ?"
				   + " WHERE id = ?";
		
		PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(sql);
		p.setString(1, t.getNome());
		p.setString(2, t.getCpf());
		p.setLong(3, t.getMatricula());
		p.setString(4, df.format(t.getDataAniversario()));
		p.setLong(5,  t.getId());
		
		p.executeQuery();
	}

	@Override
	public void delete(Integer k) throws SQLException, Exception
	{
		String sql = "DELETE FROM ALUNO"
				   + "      WHERE id = ?";
		
		PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(sql);
		p.setInt(1, k);
		
		p.executeQuery();
	}

	@Override
	public List<Aluno> findAll() throws SQLException, Exception
	{
		String sql = "SELECT id,"
				   + "       nome,"
				   + "       cpf,"
				   + "       matricula,"
				   + "       data_aniversario"
				   + "  FROM ALUNO";
		
		PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement(sql);
		
		ResultSet r = p.executeQuery();
		
		List<Aluno> ListaAlunos = new ArrayList<>();
		
		if (r.next())
		{
			Aluno aluno = new Aluno(r.getLong("id"), r.getString("nome"), r.getString("cpf"), r.getLong("matricula"), r.getDate("data_aniversario"));
			ListaAlunos.add(aluno);
		}
		
		return ListaAlunos;
	}

}