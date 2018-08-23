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
@Table(name="nota")
public class Nota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="nota")
    private Double nota;
    
    private static Nota instance;
    
    public static Nota getInstance(){
        if(instance == null){
            instance = new Nota();
        }
        return instance;
    }

    public Long getId() {
        return id;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
    
    
}
