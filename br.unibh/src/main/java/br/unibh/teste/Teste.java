package br.unibh.teste;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.unibh.entidades.Aluno;
import br.unibh.entidades.Professor;
import br.unibh.persistencia.JDBCUtil;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//for (int i = 0; i < 10; i++) {
		//System.out.println(i + 1 + " Ola Mundo!!! ");
		//}
		//Aluno a1 = new Aluno(1234L, "jo�o", "12345678909", new Date());
		//Aluno a2 = new Aluno(4321L, "Lurdinha", "12345678909");
		//Aluno a3 = new Aluno(33333L, "Wanderson");
		
		//Professor p1 = new Professor("Jose", "123456789", new BigDecimal(1500));
		//Professor p2 = new Professor("Julesca", "434343434343434");
		Aluno a1 = new Aluno(01L,"MAria", "12343434343", 1234L, new Date());
		Aluno a2 = new Aluno(02L, "Jololo", "12343434343", 1234L, new Date());
		Aluno a3 = new Aluno(03L, "Fralalau", "12343434343", 1234L, new Date());
		
	
		Professor p1 = new Professor(04L, "Afadaga", "5454545454545454", new BigDecimal(1500));
		Professor p2 = new Professor(05L, "Lelele", "5454545454545454", new BigDecimal(5500));
		
		System.out.println(Aluno.verificaMatricula("12345678"));
		System.out.println("");
		System.out.println("chamando o BONUS professor "+Professor.getBONUS());
		
		System.out.println("");
		System.out.println("");
		
		System.out.println(a1);
		System.out.println(a2);		
		System.out.println(a3);
		
		System.out.println("");
		System.out.println("");
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("");		
		try {
			ResultSet res = JDBCUtil.getConnection().prepareStatement("select * from aluno").executeQuery();
			while (res.next()){
				System.out.println(res.getLong("id")+"\t"+res.getString("nome"));
			}
			JDBCUtil.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
