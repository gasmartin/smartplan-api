package br.com.gsm.smartplan.smartplanapi.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @Column(name = "cor")
    private Integer cor;

    @Column(name = "sala")
    private Integer sala;

    @Column(name = "nome")
    private String nome;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turma")
    private List<Aluno> alunos;
    
    @ManyToOne
    private Professor professor;

    private static Turma instance;

    public static Turma getInstance() {
        if (instance == null) {
            instance = new Turma();
        }
        return instance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCor() {
        return cor;
    }

    public void setCor(Integer cor) {
        this.cor = cor;
    }

    public Integer getSala() {
        return sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
   
}
