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
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ClienteEntity clienteEntity) {
        try {
            EnderecoEntity endereco = clienteEntity.getEndereco();
            this.enderecoService.save(endereco);
            clienteService.save(clienteEntity);
            return new ResponseEntity<>("Cliente e endereço salvos com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody ClienteEntity clienteEntity,@PathVariable long id){
        try{
            String msg = this.clienteService.update(clienteEntity, id);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try{
            String msg = this.clienteService.delete(id);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<ClienteEntity>> findAll(){
        try{
            List<ClienteEntity> lista = this.clienteService.findAll();
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<ClienteEntity> findById(@PathVariable long id){
        try{
            ClienteEntity clienteEntity = this.clienteService.findById(id);
            return new ResponseEntity<>(clienteEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/idade")
    public ResponseEntity<List<ClienteEntity>> listarClientesPorIdade(@RequestParam int idadeInicio, @RequestParam int idadeFim){
        try{
            List<ClienteEntity> lista = this.clienteService.listarClientesPorIdade(idadeInicio, idadeFim);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
