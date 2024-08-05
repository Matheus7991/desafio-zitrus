package br.com.desafioZitrus.dao;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.desafiozitrus.dao.SolicitacaoDAO;
import br.com.desafiozitrus.model.Solicitacao;
import br.com.desafiozitrus.dao.util.Conexao;

public class SolicitacaoDAOTest {

    private SolicitacaoDAO solicitacaoDAO;
    private Connection connection;
    
	private void conectar() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = Conexao.getConexao();
		}
	}
	
	private void desconectar() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}

    @Before
    public void setUp() throws SQLException {
    	System.out.println("Criar");
    	conectar();

        Statement stmt = connection.createStatement();
        stmt.execute("CREATE TABLE solicitacao (" +
                     "id SERIAL PRIMARY KEY," +
                     "nome VARCHAR(255)," +
                     "procedimento INT," +
                     "idade INT," +
                     "sexo VARCHAR(255))");
        stmt.close();
    }
    
    @After
    public void tearDown() throws SQLException {
    	System.out.println("Deletar");
        Statement stmt = connection.createStatement();
        stmt.execute("DROP TABLE solicitacao");
        stmt.close();
        desconectar();
    }

    @Test
    public void testInserirSolicitacao() throws SQLException {
        Solicitacao solicitacao = new Solicitacao("João", 1234, 20, "M");
        Solicitacao result = solicitacaoDAO.inserirSolicitacao(solicitacao);

        assertNotNull(result);
        assertTrue(result.getId() > 0);

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM solicitacao WHERE id = ?");
        stmt.setLong(1, result.getId());
        ResultSet rs = stmt.executeQuery();

        assertTrue(rs.next());
        assertEquals("João", rs.getString("nome"));
        assertEquals(1234, rs.getInt("procedimento"));
        assertEquals(20, rs.getInt("idade"));
        assertEquals("M", rs.getString("sexo"));

        rs.close();
        stmt.close();
    }

    @Test
    public void testListarSolicitacoes() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("INSERT INTO solicitacao (nome, procedimento, idade, sexo) VALUES ('Matheus', 1234, 20, 'M')");
        stmt.execute("INSERT INTO solicitacao (nome, procedimento, idade, sexo) VALUES ('Maria', 4567, 30, 'F')");
        stmt.close();

        List<Solicitacao> solicitacoes = solicitacaoDAO.listarSolicitacoes();
        assertNotNull(solicitacoes);
        assertEquals(2, solicitacoes.size());

        Solicitacao sol1 = solicitacoes.get(0);
        assertEquals("Matheus", sol1.getNome());
        assertEquals(1234, sol1.getProcedimento().intValue());
        assertEquals(20, sol1.getIdade().intValue());
        assertEquals("M", sol1.getSexo());

        Solicitacao sol2 = solicitacoes.get(1);
        assertEquals("Maria", sol2.getNome());
        assertEquals(4567, sol2.getProcedimento().intValue());
        assertEquals(30, sol2.getIdade().intValue());
        assertEquals("F", sol2.getSexo());
    }
}
