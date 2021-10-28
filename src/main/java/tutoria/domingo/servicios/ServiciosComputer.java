/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutoria.domingo.modelo.Computer;
import tutoria.domingo.repositorio.RepositorioComputer;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosComputer {
     @Autowired
    private RepositorioComputer metodosCrud;
    
    public List<Computer> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Computer> getComputers(int idComputers){
        return metodosCrud.getComputers(idComputers);
    }
    
    public Computer save(Computer Computers){
        if(Computers.getId()==null){
            return metodosCrud.save(Computers);
        }else{
            Optional<Computer> evt=metodosCrud.getComputers(Computers.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(Computers);
            }else{
                return Computers;
            }
        }
    }
    public Computer update(Computer computer){
        if(computer.getId()!=null){
            Optional<Computer> e=metodosCrud.getComputers(computer.getId());
            if(!e.isEmpty()){
                if(computer.getName()!=null){
                    e.get().setName(computer.getName());
                }
                if(computer.getBrand()!=null){
                    e.get().setBrand(computer.getBrand());
                }
                if(computer.getYear()!=null){
                    e.get().setYear(computer.getYear());
                }
                if(computer.getDescription()!=null){
                    e.get().setDescription(computer.getDescription());
                }
                if(computer.getCategory()!=null){
                    e.get().setCategory(computer.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return computer;
            }
        }else{
            return computer;
        }
    }


    public boolean deleteComputer(int computerId) {
        Boolean aBoolean = getComputers(computerId).map(computer -> {
            metodosCrud.delete(computer);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
