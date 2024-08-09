package app.services;

import app.entities.EnderecoEntity;
import app.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public String save(EnderecoEntity enderecoEntity){
        this.enderecoRepository.save(enderecoEntity);
        return "Endereço Salvo";
    }

    public String update(EnderecoEntity enderecoEntity, long id){
        enderecoEntity.setId(id);
        this.enderecoRepository.save(enderecoEntity);
        return "Endereco Atualizado";
    }

    public String delete(long id){
        this.enderecoRepository.deleteById(id);
        return "Endereco Excluido";
    }

    public List<EnderecoEntity> findAll(){
        List<EnderecoEntity> lista = this.enderecoRepository.findAll();
        return lista;
    }

    public EnderecoEntity findById(long id){
        return this.enderecoRepository.findById(id).get();
    }
}
