package br.unibh.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import br.unibh.entidades.Professor;

public class ProfessorDAO implements DAO <Professor, String>
{
    @Override
    public Professor find(String cpf)
    { 
        // TODO Auto-generated method stub
        try
        {
            PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement("Select * from db_professor where id = 1");
            p.setString(1,cpf);
            ResultSet r = p.executeQuery();
            
            if (r.next())
            {
                return new Professor(r.getLong("id"), r.getString("nome"), r.getString("cpf"), r.getBigDecimal("salario"));
            }
        }
        catch (SQLException e)
        { 
        }
        catch (Exception e)
        {
        }
        return null;
    }

    public Professor Insert(Professor t)
    {
        try
        {
            PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement("Insert into tb_professor (matricula, nome, " + "cpf, data_aniversario) values (?, ?, ?, ?)");
            p.setLong(1, t.getId());
            p.setString(2, t.getNome());
            p.setString(3, t.getCpf());
            p.setBigDecimal(4, t.getSalario());
            ResultSet r = p.executeQuery();
            
            if (r.next())
            {
                return new Professor(r.getLong("id"), r.getString("nome"), r.getString("cpf"), r.getBigDecimal("salario"));
            }
        }
        catch (SQLException e)
        {
        }
        catch (Exception e)
        {
        }
        return null;
    }

    @Override
    public void update(Professor t)
    {
        try
        {
            PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement("Update into tb_professor set matricula = ?,"+" nome = ?,"+ "cpf = ?,"+ "data_aniversario = ?"+ "where id = ?");
            p.setLong(1, t.getId());
            p.setString(2, t.getNome());
            p.setString(3, t.getCpf());
            p.setBigDecimal(4, t.getSalario());

            ResultSet r = p.executeQuery();
            p.setLong(1, t.getId());
            p.executeUpdate();

        }
        catch (Exception e)
        {
        }
    }

    @Override
    public void delete(Professor t)
    {
        try
        {
            PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement("delete from tb_professor where id = ?"+ "where id = ?");
            p.setLong(1,t.getId());
            p.executeUpdate();

            ResultSet r = p.executeQuery();
            p.setLong(1, t.getId());
            p.executeUpdate();
        }
        catch (Exception e)
        {
        }
    }
    
    public List<Professor> findit()
    {
        return null;
    }
    
    public Professor find(Long id)
    {
        
        return null;
    }
    
    @Override public void insert(Professor t)
    {
    }

    @Override
    public List<Professor> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}