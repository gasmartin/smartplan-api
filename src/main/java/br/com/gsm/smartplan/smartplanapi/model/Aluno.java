package br.com.gsm.smartplan.smartplanapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Gabriel San Martin
 */
@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false, length = 20)
    private String nome;

    @Column(name = "email", nullable = true, length = 100)
    private String email;
       
    @ManyToOne
    @JoinColumn(name = "turma_id")
    @JsonIgnore
    private Turma turma;
    
    public Aluno(){
        
    }

    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
