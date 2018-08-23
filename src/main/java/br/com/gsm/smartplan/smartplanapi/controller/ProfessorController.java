/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsm.smartplan.smartplanapi.controller;

import br.com.gsm.smartplan.smartplanapi.model.Professor;
import br.com.gsm.smartplan.smartplanapi.repository.ProfessorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gabriel San Martin
 */

@RestController
@RequestMapping("/api")
public class ProfessorController {
    
     @Autowired
    ProfessorRepository professorRepository;
     
    @GetMapping("/professor")
    public List<Professor> teste(){
        Professor p = new Professor();
        p.setNome("Pedro");
        p.setEmail("vini@gmail.com");
        p.setSenha("123");
        professorRepository.save(p);
        return professorRepository.findAll();
    }
}
