package br.unibh.teste;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.unibh.entidades.Aluno;
import br.unibh.entidades.Professor;
import br.unibh.persistencia.AlunoDAO;
import br.unibh.persistencia.ProfessorDAO;

public class testes {

	@Before
	public void preparaBanco() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a1 = new Aluno(null, "Antonia", "6969696969", new Long(12345),
				new Date());
		Aluno a2 = new Aluno(null, "Zumira", "6969695555", new Long(12355),
				new Date());
		Aluno a3 = new Aluno(null, "1 2 3 de oliveira 4", "6969644444",
				new Long(12344), new Date());
		dao.insert(a1);
		dao.insert(a2);
		dao.insert(a3);
		ProfessorDAO daoP = new ProfessorDAO();
		Professor p1 = new Professor(null, "Jesus", "123456789",
				new BigDecimal(2345));
		Professor p2 = new Professor(null, "Maria", "123456710",
				new BigDecimal(2345));
		Professor p3 = new Professor(null, "Jose", "123456711", new BigDecimal(
				2345));
		daoP.insert(p1);
		daoP.insert(p2);
		daoP.insert(p3);
	}

	@After
	public void limpaBanco() {
		AlunoDAO dao = new AlunoDAO();
		dao.clean();
		ProfessorDAO daoP = new ProfessorDAO();
		daoP.clean();
	}

	@Test
	public void testeBuscarAluno() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(1L);
		Assert.assertEquals(a.getCpf(), "6969696969");
	}

	@Test
	public void testeBuscaProfessor() {
		ProfessorDAO dao = new ProfessorDAO();
		Professor a = dao.find(1L);
		Assert.assertEquals(a.getCpf(), "123456789");
	}

	@Test
	public void testeAlunoInsert() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = new Aluno(null, "joana", "12345", 12345L, new Date());
		Aluno a3 = new Aluno(null, "Wanderson", "12345678911", 12345L,
				new Date());
		dao.insert(a);
		dao.insert(a3);
	}

	@Test
	public void testeProfessorInsert() {
		ProfessorDAO dao = new ProfessorDAO();
		Professor a = new Professor(null, "nonoca", "5555", new BigDecimal(44));
		Professor a2 = new Professor(null, "HINODE", "123", new BigDecimal(444));
		dao.insert(a);

		dao.insert(a2);
	}

	@Test
	public void alunoUpdate() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(1L);
		a.setNome("Esmeralda");
		dao.update(a);
	}

	@Test
	public void alunoDelete() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(1L);
		dao.delete(a);
		List<Aluno> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 2);
	}

	@Test
	public void alunosLista() {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 3);
	}

	@Test
	public void professorUpdate() {
		ProfessorDAO dao = new ProfessorDAO();
		Professor a = dao.find(1L);
		// System.out.print(a);
		a.setNome("Saul Seixas");
		a.setSalario(new BigDecimal(212));
		dao.update(a);
	}

	@Test
	public void professorDelete() {
		ProfessorDAO dao = new ProfessorDAO();
		Professor a = dao.find(1L);
		dao.delete(a);
		List<Professor> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 2);
	}

	@Test
	public void professorList() {
		ProfessorDAO dao = new ProfessorDAO();
		List<Professor> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 3);
	}
}
