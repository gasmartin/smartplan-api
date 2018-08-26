/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsm.smartplan.smartplanapi.controller;

import br.com.gsm.smartplan.smartplanapi.exception.ResourceNotFoundException;
import br.com.gsm.smartplan.smartplanapi.model.Aluno;
import br.com.gsm.smartplan.smartplanapi.repository.AlunoRepository;
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
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    //Retorna dados de um determinado aluno.
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(alunoRepository.findById(id), HttpStatus.OK);
    }

    //Retorna todos os planejamentos.
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listOfAlunos() {
        return new ResponseEntity<>(alunoRepository.findAll(), HttpStatus.OK);
    }

    //Cria um planejamento.
    @RequestMapping(method = RequestMethod.POST, path = "/cadastrar")
    public ResponseEntity<?> insertAluno(@Valid @RequestBody Aluno aluno) {
        return new ResponseEntity<>(alunoRepository.save(aluno), HttpStatus.OK);
    }

    //Atualiza um determinado professor.
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<?> updateAluno(@PathVariable("id") Long aluno_id,
            @Valid @RequestBody Aluno aluno_details) {

        Aluno aluno = alunoRepository.findById(aluno_id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno", "aluno", aluno_id));

        aluno.setNome(aluno_details.getNome());
        aluno.setObs(aluno_details.getObs());
        aluno.setEmail(aluno_details.getEmail());

        //TALVEZ UM SET PARA AS NOTAS AQUI
        //VOU VER DEPOIS, TÁ?
        //NÃO ESQUECE
        return new ResponseEntity<>(alunoRepository.save(aluno), HttpStatus.OK);
    }

    //Deleta um planejamento.
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> deleteAluno(@PathVariable("id") Long aluno_id) {
        Aluno aluno = alunoRepository.findById(aluno_id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno", "id", aluno_id));

        alunoRepository.delete(aluno);

        return ResponseEntity.ok().build();
    }
}
