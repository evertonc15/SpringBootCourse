package SpringBootCourse.evertonc15.com.github.produtosapi.repository;

import SpringBootCourse.evertonc15.com.github.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {


}
