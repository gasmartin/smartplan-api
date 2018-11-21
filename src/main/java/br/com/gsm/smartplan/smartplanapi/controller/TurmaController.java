/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsm.smartplan.smartplanapi.controller;

import br.com.gsm.smartplan.smartplanapi.exception.ResourceNotFoundException;
import br.com.gsm.smartplan.smartplanapi.model.Turma;
import br.com.gsm.smartplan.smartplanapi.repository.ProfessorRepository;
import br.com.gsm.smartplan.smartplanapi.repository.TurmaRepository;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gabriel San Martin
 */
@RestController
@RequestMapping("/api")
public class TurmaController {
    
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    //Retorna dados de uma determinada turma.
    @RequestMapping(method = RequestMethod.GET, path = "/turma/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(turmaRepository.findById(id), HttpStatus.OK);
    }

    //Retorna todas as turmas.
    @RequestMapping(method = RequestMethod.GET, path = "/turma")
    public ResponseEntity<?> listOfTurmas() {
        return new ResponseEntity<>(turmaRepository.findAll(), HttpStatus.OK);
    }
 
    //Cria uma turma.
    @RequestMapping(method = RequestMethod.POST, path = "/turma/insert/{id}")
    public ResponseEntity<?> insertTurma(@Valid @RequestBody Turma turma, @PathVariable("id") Long id) {
        turma.setProfessor(professorRepository.findById(id).get());
        return new ResponseEntity<>(turmaRepository.save(turma), HttpStatus.OK);
    }

    //Atualiza uma determinada turma.
    @RequestMapping(method = RequestMethod.PUT, path = "/turma/{id}")
    public ResponseEntity<?> updateTurma(@PathVariable("id") Long turma_id,
            @Valid @RequestBody Turma turma_details) {

        Turma turma = turmaRepository.findById(turma_id)
                .orElseThrow(() -> new ResourceNotFoundException("Turma", "turma", turma_id));
        
        turma.setSala(turma_details.getSala());
        turma.setNome(turma_details.getNome());

        return new ResponseEntity<>(turmaRepository.save(turma), HttpStatus.OK);
    }

    //Deleta um planejamento.
    @RequestMapping(method = RequestMethod.DELETE, path = "/turma/{id}")
    public ResponseEntity<?> deleteTurma(@PathVariable("id") Long turma_id) {
        Turma turma = turmaRepository.findById(turma_id)
                .orElseThrow(() -> new ResourceNotFoundException("Turma", "id", turma_id));

        turmaRepository.delete(turma);

        return ResponseEntity.ok().build();
    }
    
    //Retorna turmas de um determinado professor.
    @RequestMapping(method = RequestMethod.GET, path = "/professor/{id}/turmas")
    @Transactional
    public ResponseEntity<?> getAllTurmasByProfessorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(turmaRepository.findByProfessorId(id), HttpStatus.OK);
    }
}
