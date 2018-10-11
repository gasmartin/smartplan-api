/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsm.smartplan.smartplanapi.repository;


import br.com.gsm.smartplan.smartplanapi.model.Professor;
import br.com.gsm.smartplan.smartplanapi.model.Turma;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gabriel San Martin
 */

@Component
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    public Professor getByUsername(String username);
}
