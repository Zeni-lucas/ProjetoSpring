package app.repositories;

import app.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity,Long> {

    List<ProdutoEntity> findTop10ByOrderByPrecoDesc();
}
