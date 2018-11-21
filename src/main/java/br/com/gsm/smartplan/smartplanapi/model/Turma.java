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
@Table(name = "turmas")
public class Turma {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "sala", nullable = true)
    private int sala;

    @Column(name = "nome", nullable = false, length = 20)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @JsonIgnore
    private Professor professor;
    
    @ManyToOne
    @JoinColumn(name = "planejamento_id")
    @JsonIgnore
    private Planejamento planejamento;
    
    public Turma(){
        
    }

    public Turma(int cor, Integer sala, String nome, String descricao) {
        this.sala = sala;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Planejamento getPlanejamento() {
        return planejamento;
    }

    public void setPlanejamento(Planejamento planejamento) {
        this.planejamento = planejamento;
    }
    
}
