/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsm.smartplan.smartplanapi.controller;

import br.com.gsm.smartplan.smartplanapi.model.Professor;
import br.com.gsm.smartplan.smartplanapi.model.Usuario;
import br.com.gsm.smartplan.smartplanapi.repository.ProfessorRepository;
import br.com.gsm.smartplan.smartplanapi.repository.UsuarioRepository;
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
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private ProfessorRepository professorRepository;
    
    //Retorna dados de um determinado professor através do e-mail.
    @RequestMapping(method = RequestMethod.GET, path = "/usuario/executar_login/{username}/{password}")
    public ResponseEntity<?> login(@PathVariable("username") String username, @PathVariable("senha") String password) {
        Usuario usuario = usuarioRepository.findById(username).get();
        if (usuario != null) {
            if (usuario.getPassword().equals(password)) {
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
        
    //Insere um usuário
    @RequestMapping(method = RequestMethod.POST, path = "usuario/insert/{professor_id}")
    public ResponseEntity<?> insertUsuario(@Valid @RequestBody Usuario usuario, @PathVariable("professor_id") Long professor_id){
        Professor professor = professorRepository.findById(professor_id).get();
        professor.setUsuario(usuario);
        return new ResponseEntity<Professor>(professorRepository.save(professor), HttpStatus.OK);
    }
}
