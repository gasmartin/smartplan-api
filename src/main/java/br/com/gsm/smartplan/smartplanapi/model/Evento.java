package br.com.gsm.smartplan.smartplanapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gabriel San Martin
 */
@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "tipo")
    private Character tipo;

    @Column(name = "data_evento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEvento;

    @ManyToOne
    @JoinColumn(name = "planejamento_id")
    @JsonIgnore
    private Planejamento planejamento;

//    private static Evento instance;
//
//    public static Evento getInstance() {
//        if (instance == null) {
//            instance = new Evento();
//        }
//        return instance;
//    }
    
    public Evento(){
        
    }

    public Evento(String nome, String descricao, Character tipo, Date dataEvento) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.dataEvento = dataEvento;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Planejamento getPlanejamento() {
        return planejamento;
    }

    public void setPlanejamento(Planejamento planejamento) {
        this.planejamento = planejamento;
    }

}
