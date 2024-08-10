package app.controllers;

import app.entities.ClienteEntity;
import app.entities.EnderecoEntity;
import app.entities.FuncionarioEntity;
import app.services.ClienteService;
import app.services.EnderecoService;
import app.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody FuncionarioEntity funcionarioEntity ) {
        try {
            EnderecoEntity endereco = funcionarioEntity.getEndereco();
            this.enderecoService.save(endereco);
            funcionarioService.save(funcionarioEntity);
            return new ResponseEntity<>("Funcionario e endereço salvos com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody FuncionarioEntity funcionarioEntity,@PathVariable long id){
        try{
            String msg = this.funcionarioService.update(funcionarioEntity, id);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try{
            String msg = this.funcionarioService.delete(id);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<FuncionarioEntity>> findAll(){
        try{
            List<FuncionarioEntity> lista = this.funcionarioService.findAll();
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<FuncionarioEntity> findById(@PathVariable long id){
        try{
            FuncionarioEntity funcionarioEntity = this.funcionarioService.findById(id);
            return new ResponseEntity<>(funcionarioEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
