package app.controllers;

import app.entities.ClienteEntity;
import app.entities.VendaEntity;
import app.services.ClienteService;
import app.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody VendaEntity vendaEntity){
        try{
            String msg = this.vendaService.save(vendaEntity);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody VendaEntity vendaEntity,@PathVariable long id){
        try{
            String msg = this.vendaService.update(vendaEntity, id);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try{
            String msg = this.vendaService.delete(id);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<VendaEntity>> findAll(){
        try{
            List<VendaEntity> lista = this.vendaService.findAll();
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<VendaEntity> findById(@PathVariable long id){
        try{
            VendaEntity vendaEntity = this.vendaService.findById(id);
            return new ResponseEntity<>(vendaEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
