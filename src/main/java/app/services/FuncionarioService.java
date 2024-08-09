package app.services;

import app.entities.FuncionarioEntity;
import app.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public String save(FuncionarioEntity funcionarioEntity){
        this.funcionarioRepository.save(funcionarioEntity);
        return "Funcionario Salvo";
    }

    public String update(FuncionarioEntity funcionarioEntity, long id){
        funcionarioEntity.setId(id);
        this.funcionarioRepository.save(funcionarioEntity);
        return "Funcionario Atualizado";
    }

    public String delete(long id){
        this.funcionarioRepository.deleteById(id);
        return "Excluido Com Sucesso";
    }

    public List<FuncionarioEntity> findAll(){
        List<FuncionarioEntity> lista = this.funcionarioRepository.findAll();
        return lista;
    }

    public FuncionarioEntity findById(long id){
        return this.funcionarioRepository.findById(id).get();
    }
}
