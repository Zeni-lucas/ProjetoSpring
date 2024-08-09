package app.controllers;

import app.entities.ClienteEntity;
import app.entities.EnderecoEntity;
import app.services.ClienteService;
import app.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody EnderecoEntity enderecoEntity){
        try{
            String msg = this.enderecoService.save(enderecoEntity);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody EnderecoEntity enderecoEntity,@PathVariable long id){
        try{
            String msg = this.enderecoService.update(enderecoEntity, id);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try{
            String msg = this.enderecoService.delete(id);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<EnderecoEntity>> findAll(){
        try{
            List<EnderecoEntity> lista = this.enderecoService.findAll();
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<EnderecoEntity> findById(@PathVariable long id){
        try{
            EnderecoEntity enderecoEntity = this.enderecoService.findById(id);
            return new ResponseEntity<>(enderecoEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
