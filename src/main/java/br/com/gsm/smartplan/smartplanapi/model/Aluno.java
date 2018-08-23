package br.com.gsm.smartplan.smartplanapi.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Gabriel San Martin
 */
@Entity
@Table(name="aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="obs")
    private String obs;

    @Column(name="email")
    private String email;

    @OneToMany
    private List<Nota> notas;

    private static Aluno instance;

    public static Aluno getInstance() {
        if (instance == null) {
            instance = new Aluno();
        }
        return instance;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
