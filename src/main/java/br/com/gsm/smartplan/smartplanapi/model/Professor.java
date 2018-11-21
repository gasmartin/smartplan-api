package br.com.gsm.smartplan.smartplanapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gabriel San Martin
 */
@Entity
@Table(name = "professores")
public class Professor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false, length = 20)
    private String nome;
    
    @Column(name = "email", nullable = true, length = 35)
    private String email;

    @Column(name = "username", unique = true, nullable = false, length = 20)
    private String username;

    @Column(name = "senha", nullable = false, length = 20)
    private String senha;
    
    public Professor(){
        
    }

    public Professor(String nome, String username, String senha) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
