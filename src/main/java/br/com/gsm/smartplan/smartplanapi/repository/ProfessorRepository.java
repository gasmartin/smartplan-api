/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsm.smartplan.smartplanapi.repository;


import br.com.gsm.smartplan.smartplanapi.model.Professor;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Gabriel San Martin
 */
public interface ProfessorRepository extends CrudRepository<Professor, Long>{
    
    public Professor getByEmail(String email);
}
