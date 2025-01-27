package SpringBootCourse.evertonc15.com.github.produtosapi.repository;

import SpringBootCourse.evertonc15.com.github.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByNome(String nome);
}
