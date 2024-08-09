package app.services;

import app.entities.ProdutoEntity;
import app.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public String save(ProdutoEntity produtoEntity){
        this.produtoRepository.save(produtoEntity);
        return "Produto Salvo";
    }

    public String update(ProdutoEntity produtoEntity, long id){
        produtoEntity.setId(id);
        this.produtoRepository.save(produtoEntity);
        return "Produto Atualizado";
    }

    public String delete(long id){
        this.produtoRepository.deleteById(id);
        return "Excluido com Sucesso";
    }

    public List<ProdutoEntity> findAll(){
        List<ProdutoEntity> lista = this.produtoRepository.findAll();
        return lista;
    }
    public ProdutoEntity findById(long id){
        return this.produtoRepository.findById(id).get();
    }
}
