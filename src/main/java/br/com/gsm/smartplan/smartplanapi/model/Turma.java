package br.com.gsm.smartplan.smartplanapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gabriel San Martin
 */

@Entity
@Table(name="turma")
public class Turma {
	
        @Id
        @Column(name="id")
	private Long id;
        
        @Column(name="cor")
	private Integer cor;
        
        @Column(name="sala")
	private Integer sala;
        
        @Column(name="nome")
	private String nome;

	private static Turma instance;
	
	public static Turma getInstance() {
		if(instance == null) {	
			instance = new Turma();
		}
		return instance;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public Integer getCor() {
		return this.cor;
	}
	
	public void setCor(int cor) {
		this.cor = cor;
	}
	
	public Integer getSala() {
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
