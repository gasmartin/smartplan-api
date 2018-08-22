package br.com.gsm.smartplan.smartplanapi.model;

//import java.sql.Date;

public class Planejamento {
	
	private int id;
	private int cor;
	private String nome;
	private String descricao;
	//private Date dataIni;
	//private Date dataFim;
	
	private static Planejamento instance;
	
	public static Planejamento getInstance() {
		if(instance == null) {
			instance = new Planejamento();
		}
		return instance;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getCor() {
		return this.cor;
	}
	
	public void setCor(int cor) {
		this.cor = cor;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
