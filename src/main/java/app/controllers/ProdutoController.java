package app.controllers;

import app.entities.ClienteEntity;
import app.entities.ProdutoEntity;
import app.services.ClienteService;
import app.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ProdutoEntity produtoEntity){
        try{
            String msg = this.produtoService.save(produtoEntity);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody ProdutoEntity produtoEntity,@PathVariable long id){
        try{
            String msg = this.produtoService.update(produtoEntity, id);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try{
            String msg = this.produtoService.delete(id);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<ProdutoEntity>> findAll(){
        try{
            List<ProdutoEntity> lista = this.produtoService.findAll();
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<ProdutoEntity> findById(@PathVariable long id){
        try{
            ProdutoEntity produtoEntity = this.produtoService.findById(id);
            return new ResponseEntity<>(produtoEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
