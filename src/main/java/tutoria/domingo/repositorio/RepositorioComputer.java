/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tutoria.domingo.modelo.Mensaje;
import tutoria.domingo.modelo.Computer;
import tutoria.domingo.interfaces.InterfaceComputer;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioComputer {
     @Autowired
    private InterfaceComputer crud;
    

    public List<Computer> getAll(){
        return (List<Computer>) crud.findAll();       
    }
    
    public Optional <Computer> getComputers(int id){
        return crud.findById(id);
    }
    
    public Computer save(Computer computer){
        return crud.save(computer);
    }
      public void delete(Computer computer){
        crud.delete(computer);
    }
    
    
}
