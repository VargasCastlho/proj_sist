/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.ifes.entidade.Fabricante;
import com.ifes.interfaces.PopUp;
import com.ifes.interfaces.TelaPrincipal;
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
         } catch (SQLException ex) {
             Logger.getLogger(FabricanteService.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(FabricanteService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return result;
    }
    
    
    public Fabricante insertFabricante(Fabricante fabricante){
        Fabricante result = null;
         try {  
             this.fabricanteRepository.insert(fabricante);
         } catch (SQLException ex) {
             Logger.getLogger(FabricanteService.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(FabricanteService.class.getName()).log(Level.SEVERE, null, ex);
         } catch(Exception ex){
             Logger.getLogger(FabricanteService.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        return result;
    }
     
}
