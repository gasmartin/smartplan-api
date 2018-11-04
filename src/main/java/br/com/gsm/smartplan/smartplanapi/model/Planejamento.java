package br.com.gsm.smartplan.smartplanapi.model;

/**
 *
 * @author Gabriel San Martin
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Date;
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

@Entity
@Table(name = "planejamentos")
public class Planejamento {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cor", nullable = true)
    private Integer cor;

    @Column(name = "nome", nullable = false, length = 20)
    private String nome;

    @Column(name = "descricao", nullable = true, length = 100)
    private String descricao;

    @Column(name = "data_inicio")
    private String dataInicio;

    @Column(name = "data_final")
    private String dataFinal;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @JsonIgnore
    private Professor professor;

    private static Planejamento instance;

    public static Planejamento getInstance() {
        if (instance == null) {
            instance = new Planejamento();
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
