package app.repositories;

import app.entities.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendaRepository extends JpaRepository<VendaEntity,Long> {

    List<VendaEntity> findByClienteNomeContaining(String nome);

    List<VendaEntity> findByFuncionarioNomeContaining(String nome);

    List<VendaEntity> findTop10ByOrderByTotalVendaDesc();
}
