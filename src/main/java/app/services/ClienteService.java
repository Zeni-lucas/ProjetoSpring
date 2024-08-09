package app.services;

import app.entities.ClienteEntity;
import app.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public String save(ClienteEntity clienteEntity){
        this.clienteRepository.save(clienteEntity);
        return "Cliente Salvo";
    }

    public String update(ClienteEntity clienteEntity, long id){
        clienteEntity.setId(id);
        this.clienteRepository.save(clienteEntity);
        return "Cliente foi alterado";
    }

    public String delete(long id){
        this.clienteRepository.deleteById(id);
        return "Excluido com sucesso";
    }

    public List<ClienteEntity> findAll(){
        List<ClienteEntity> lista = this.clienteRepository.findAll();
        return lista;
    }

    public ClienteEntity findById(long id){
        return this.clienteRepository.findById(id).get();
    }
}
