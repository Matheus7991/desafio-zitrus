package br.com.desafiozitrus.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desafiozitrus.dao.SolicitacaoDAO;
import br.com.desafiozitrus.model.Solicitacao;

import com.google.gson.Gson;


@WebServlet("/publica")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private SolicitacaoDAO solicitacaoDAO;
	
	public IndexController() {
        super();
    }
    
    public void init() {
    	solicitacaoDAO = new SolicitacaoDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processar(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processar(request, response);
	}
	
	protected void processar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		try {
			
			switch (acao) {
			
			case "nova": 
				novaAutorizacao(request, response);
				break;
				
			case "listar":
				listarAutorizacoes(request, response);
				break;
				
			case "salvar":
				salvarAutorizacao(request, response);
				break;
				
			case "listAut":
				listAut(request, response);
				break;
				
			} 
			
		} catch (Exception e) {
			throw new ServletException();
		}
	}
	
	private void novaAutorizacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("publica/nova-autorizacao.jsp");
			dispatcher.forward(request, response);
		}
	
	private void listarAutorizacoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		//Metodo para carregar table
		//List<Solicitacao> list = solicitacaoDAO.listarSolicitacoes();		
		//request.setAttribute("listaSolicitacoes", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/listar-autorizacoes.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	private void salvarAutorizacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		String msg = null;
		String alert = null;
		
		String nome = request.getParameter("nome");
		Integer procedimento = Integer.parseInt(request.getParameter("procedi"));
		Integer idade = Integer.parseInt(request.getParameter("idade"));
		String sexo = request.getParameter("sexo");
		
		Solicitacao sol = new Solicitacao(nome, procedimento, idade, sexo);
		
		if (procedimento == 1234) {
			if(sexo.equals("M") && idade == 20 ) {
				
				solicitacaoDAO.inserirSolicitacao(sol);
				msg = "Solicitação cadastrada!!!";
				alert = "alert-success";
				
			} else {
				msg = "Erro!!! O procedimento informado é permitido apenas para o sexo masculino com 20 anos";
				alert = "alert-danger";
			}
		} else if (procedimento == 4567) {
			if ((sexo.equals("F") && idade == 30) || (sexo.equals("M") && idade == 20)) {
				
				solicitacaoDAO.inserirSolicitacao(sol);
				msg = "Solicitação cadastrada!!!";
				alert = "alert-success";
				
			} else {
				msg = "Erro!!! A idade informada não é permitida para este procediemnto";
				alert = "alert-danger";
			}
		} else if (procedimento == 6789) {
			if (sexo.equals("M") && idade == 10) {
				
				solicitacaoDAO.inserirSolicitacao(sol);
				msg = "Solicitação cadastrada!!!";
				alert = "alert-success";
				
			} else {
				msg = "Erro!!! O procedimento informado é permitido apenas para o sexo masculino com 10 anos";
				alert = "alert-danger";
			}
		} else {
			msg = "Erro!!! O procedimento inválido";
			alert = "alert-danger";
		}				
						
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/nova-autorizacao.jsp");
		request.setAttribute("mensagem", msg);
		request.setAttribute("alert", alert);
		dispatcher.forward(request, response);

		
	}
	
	    private void listAut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	
	    	//Metodo Ajax
	    	
	        List<Solicitacao> listaSolicitacoes = solicitacaoDAO.listarSolicitacoes();

	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");

	        Gson gson = new Gson();
	        String json = gson.toJson(listaSolicitacoes);
	        response.getWriter().write(json);
	    }
	
}


