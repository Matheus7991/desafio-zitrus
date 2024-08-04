package br.com.desafiozitrus.model;

public class Solicitacao {
	
	private Long id;
	private String nome;
	private Integer procedimento;
	private Integer idade;
	private String sexo;
	
	public Solicitacao() {
		
	}

	public Solicitacao(String nome, Integer procedimento, Integer idade, String sexo) {
		super();
		this.nome = nome;
		this.procedimento = procedimento;
		this.idade = idade;
		this.sexo = sexo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Integer procedimento) {
		this.procedimento = procedimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Solicitacao [nome=" + nome + ", procedimento=" + procedimento + ", idade=" + idade + ", sexo=" + sexo
				+ "]";
	}
	
	
}
