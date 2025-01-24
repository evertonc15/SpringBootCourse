package SpringBootCourse.evertonc15.com.github.produtosapi.controller;

import SpringBootCourse.evertonc15.com.github.produtosapi.model.Produto;
import SpringBootCourse.evertonc15.com.github.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController //Vai Receber operações rest's
@RequestMapping("produtos") //Vai dizer qual url que vai ser
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping //Salvar o recurso no servidor
    public Produto salvarProduto(@RequestBody/*Objeto que vai vim do body da requisição*/ Produto produto){
        System.out.println("Produto Salvo: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }


}
