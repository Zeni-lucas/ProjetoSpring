package app.services;

import app.entities.ProdutoEntity;
import app.entities.VendaEntity;
import app.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    private ProdutoEntity produtoEntity;

    public String save(VendaEntity vendaEntity) {
        calcularTotalVenda(vendaEntity);
        this.vendaRepository.save(vendaEntity);
        return "Venda Salva";
    }

    public void calcularTotalVenda(VendaEntity venda) {
        double total = venda.getProdutos().stream()
                .mapToDouble(ProdutoEntity::getPreco)
                .sum();
        venda.setTotalVenda(total);
    }

    public String update(VendaEntity vendaEntity, long id){
        vendaEntity.setId(id);
        this.vendaRepository.save(vendaEntity);
        return "Venda Atualizada";
    }

    public String delete(long id){
        this.vendaRepository.deleteById(id);
        return "Venda Excluida";
    }

    public List<VendaEntity> findAll(){
        List<VendaEntity> lista = this.vendaRepository.findAll();
        return lista;
    }

    public VendaEntity findById(long id){
        return this.vendaRepository.findById(id).get();
    }

}
