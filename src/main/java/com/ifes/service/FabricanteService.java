/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifes.service;

import com.ifes.entidade.Fabricante;
import com.ifes.repository.FabricanteRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prisc
 */
public class FabricanteService {
  private FabricanteRepository fabricanteRepository = new FabricanteRepository();

    public FabricanteService() {
    }
     
    public ArrayList<Fabricante> findAllFabricantes()  {
        ArrayList<Fabricante>  result = null;
         try {  
             result = this.fabricanteRepository.findAll();
         }catch(Exception ex){
            
         }
        return result;
    }
    
    
    public Fabricante insertFabricante(String nome, String pais){
        Fabricante result = null;
         try {  
             Fabricante fabricante = new Fabricante(nome, pais);
             result = fabricanteRepository.insert(fabricante);
         } catch(Exception ex){
            
         }
         
        return result;
    }  

    public Fabricante findByFilterFabricante(Fabricante fabricante) {
         Fabricante result = null;
         try {  
             result = fabricanteRepository.findFabricante(fabricante);
         } catch(Exception ex){
            
         }
         
        return result;
    }
    
    public Fabricante removeFabricante(Fabricante fabricante) {
         Fabricante result = null;
         try {  
             result = fabricanteRepository.findFabricante(fabricante);
             if(result != null){
                 fabricanteRepository.delete(result.getIdFabricante());
             }
         } catch(Exception ex){
            
         }
         
        return result;
    }
}
