package br.com.gsm.smartplan.smartplanapi.model;

public class Turma {
	
	private int id;
	private int cor;
	private int sala;
	private String nome;

	private static Turma instance;
	
	public static Turma getInstance() {
		if(instance == null) {	
			instance = new Turma();
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
	
	public int getSala() {
		return this.sala;
	}
	
	public void setSala(int sala) {
		this.sala = sala;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
