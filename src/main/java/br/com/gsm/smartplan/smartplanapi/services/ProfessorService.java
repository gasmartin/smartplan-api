/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gsm.smartplan.smartplanapi.services;

import br.com.gsm.smartplan.smartplanapi.hibernate.HibernateFactory;
import br.com.gsm.smartplan.smartplanapi.model.Professor;
import br.com.gsm.smartplan.smartplanapi.repository.ProfessorRepository;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */

@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorRepository;
    
    public Optional<Professor> findById(Long id){
        return professorRepository.findById(id);
    }
    
    public Professor findByEmail(){
        HibernateFactory.initSessionFactory();
        Session session = HibernateFactory.getSessionFactory().openSession();
        Query query;
        Professor p = null;
        String hql = "from Professor as p where p.email like 'gab@gmail.com'";
        try{
            session.beginTransaction();
            query = session.createQuery(hql);
            query.setMaxResults(1);
            p = (Professor) query.uniqueResult();
            System.out.println(p);
            session.getTransaction().commit();
        }
        catch(HibernateException ex){
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }
        HibernateFactory.closeSession();
        return p;
    }
    
    public List<Professor> findAll(){
        return (List<Professor>) professorRepository.findAll();
    }
}
