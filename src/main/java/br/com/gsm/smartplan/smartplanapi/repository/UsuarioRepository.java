/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsm.smartplan.smartplanapi.repository;

import br.com.gsm.smartplan.smartplanapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gabriel San Martin
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    
}
