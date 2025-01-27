package SpringBootCourse.evertonc15.com.github.produtosapi.controller;

import SpringBootCourse.evertonc15.com.github.produtosapi.model.Produto;
import SpringBootCourse.evertonc15.com.github.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @GetMapping("{id}")
    public Produto obterPorId(@PathVariable("id") String id){
/*        Optional<Produto> produto = produtoRepository.findById(id);
        return  produto.isPresent() ? produto.get() : null;*/
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletarProduto(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizarProduto(@PathVariable("id") String id,
                                 @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscarProdutos(@RequestParam("nome") String nome){
        return produtoRepository.findByNome(nome);
    }
}
