/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsm.smartplan.smartplanapi.controller;

import br.com.gsm.smartplan.smartplanapi.model.Professor;
import br.com.gsm.smartplan.smartplanapi.repository.ProfessorRepository;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gabriel San Martin
 */
@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    ProfessorRepository professorRepository;
    
    @RequestMapping("/efetuarLogin")
    public String efetuarLogin(Professor professor, HttpSession session){
        String resultado;
        
        if(professorRepository.existsById(professor.getId())) resultado = "Sim";
        else resultado = "Nao";
        
        return resultado;
 
    }
    
    //Retorna dados de um determinado professor.
    @RequestMapping(method = RequestMethod.GET, path="/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(professorRepository.findById(id), HttpStatus.OK);
    }
}
