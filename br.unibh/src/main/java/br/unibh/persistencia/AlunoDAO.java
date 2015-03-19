package br.unibh.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import br.unibh.entidades.Aluno;

public class AlunoDAO implements DAO <Aluno,Long>
{
    private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public Aluno find(String cpf)
    {
        try
        {
            PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement("SELECT * FROM aluno WHERE id = 1");
            p.setString(1, cpf);
            ResultSet r = p.executeQuery();
            
            if (r.next())
            {
                return new Aluno(r.getLong("id"), r.getString("cpf"), r.getString("nome"), r.getLong("matricula"), df.parse(r.getString("data_aniversario")));
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
    
    public Aluno Insert(Aluno t)
    {
        try
        {
            PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement("Insert into tb_aluno (matricula, nome, " + "cpf, data_aniversario) values (?, ?, ?, ?)");
            p.setLong(1, t.getMatricula());
            p.setString(2, t.getNome());
            p.setString(3, t.getCpf());
            
            if (t.getDataAniversario() == null)
            {
                p.setNull(4, Types.NULL);
            }
            else
            {
                p.setString(4, df.format(t.getDataAniversario()));
            }
            
            ResultSet r = p.executeQuery();
            
            if (r.next())
            {
                return new Aluno(r.getLong("id"), r.getString("cpf"), r.getString("nome"), r.getLong("matricula"), df.parse(r.getString("data_aniversario")));
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
    public void update(Aluno t)
    {
        try
        {
            PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement("Update into tb_aluno set matricula = ?,"+" nome = ?,"+ "cpf = ?,"+ "data_aniversario = ?"+ "where id = ?");
            p.setLong(1,t.getMatricula());
            p.setString(2, t.getNome());
            p.setString(3, t.getCpf());
            
            if (t.getDataAniversario() == null)
            {
                p.setNull(4, Types.NULL);
            }
            else
            {
                p.setString(4, df.format(t.getDataAniversario()));
            }

            ResultSet r = p.executeQuery();
            p.setLong(1, t.getId());
            p.executeUpdate();
        }
        catch (Exception e)
        {
        }
    }

    @Override
    public void delete(Aluno t)
    {
        try
        {
            PreparedStatement p = (PreparedStatement) JDBCUtil.getConnection().prepareStatement("delete from tb_aluno where id = ?"+ "where id = ?");
            p.setLong(1,t.getId());
            p.executeUpdate();
            
            if (t.getDataAniversario() == null)
            {
                p.setNull(4, Types.NULL);
            }
            else
            {
                p.setString(4, df.format(t.getDataAniversario()));
            }

            ResultSet r = p.executeQuery();
            p.setLong(1, t.getId());
            p.executeUpdate();
        }
        catch (Exception e)
        {
        }
    }

    public List<Aluno> findit()
    {
        return null;
    }
    
    @Override
    public Aluno find(Long id)
    {
        return null;
    }
    
    @Override public void insert(Aluno t)
    {
    }

    @Override
    public List<Aluno> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void clean() {
        try {
            JDBCUtil.getConnection().prepareStatement("truncate tb_aluno")
                    .executeUpdate();
            JDBCUtil.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}