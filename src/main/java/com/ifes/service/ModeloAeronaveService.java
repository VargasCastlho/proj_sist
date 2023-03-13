/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifes.service;

import com.ifes.entidade.Fabricante;
import com.ifes.entidade.ModeloAeronave;
import com.ifes.repository.FabricanteRepository;
import com.ifes.repository.ModeloAeronaveRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prisc
 */
public class ModeloAeronaveService {
    private ModeloAeronaveRepository modeloAeronaveRepository = new ModeloAeronaveRepository();
    private FabricanteRepository fabricanteRepository = new FabricanteRepository();
     
    public ModeloAeronaveService() {
    }

    public ArrayList<ModeloAeronave> findAllModelosAeronaves() {
        ArrayList<ModeloAeronave>  result = null;
         try {  
             result = this.modeloAeronaveRepository.findAll();
             if(result != null && !result.isEmpty()){
                 result.forEach(resp -> {
                     try {
                         Fabricante fabricante = this.fabricanteRepository.findById(resp.getFabricante().getIdFabricante());
                         resp.setFabricante(fabricante);
                     } catch (ClassNotFoundException ex) {
                         Logger.getLogger(ModeloAeronaveService.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (SQLException ex) {
                         Logger.getLogger(ModeloAeronaveService.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 });
             }
         } catch(Exception ex){
            
         }
        return result;
    }

    public ModeloAeronave insertModeloAeronave(ModeloAeronave modelo) {
       ModeloAeronave result = null;
         try {  
             result = this.modeloAeronaveRepository.insert(modelo);
         } catch(Exception ex){
            
         }
         
        return result;
    }
    
}
