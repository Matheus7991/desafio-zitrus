package br.com.desafiozitrus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.desafiozitrus.dao.util.Conexao;
import br.com.desafiozitrus.model.Solicitacao;

public class SolicitacaoDAO {

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
	
	public Solicitacao inserirSolicitacao(Solicitacao sol) throws SQLException {
		String sql = "INSERT INTO solicitacao (nome, procedimento, idade, sexo) "
					  + "VALUES (?, ?, ?, ?)";
		
		conectar();
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, sol.getNome());
		statement.setInt(2, sol.getProcedimento());
		statement.setInt(3, sol.getIdade());
		statement.setString(4, sol.getSexo());
		
		statement.executeUpdate();
		
		ResultSet rs = statement.getGeneratedKeys();
		long id = 0;
		if(rs.next()) {
			id = rs.getInt("id");
		}
		statement.close();
		
		desconectar();
		
		sol.setId(id);
		return sol;
	}
	
	public List<Solicitacao> listarSolicitacoes() throws SQLException {
		
		List<Solicitacao> list = new ArrayList<Solicitacao>();
		
		String sql = "SELECT * FROM solicitacao";
		
		conectar();
		
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		while(rs.next()) {
			long id = rs.getLong("id");
			String nome = rs.getString("nome");
			Integer procedimento = rs.getInt("procedimento");
			Integer idade = rs.getInt("idade");
			String sexo = rs.getString("sexo");
			
			Solicitacao sol = new Solicitacao(nome, procedimento, idade, sexo);
			sol.setId(id);
			list.add(sol);
		}
		
		rs.close();
		statement.close();
		
		desconectar();
		
		return list;
	}
	
}
