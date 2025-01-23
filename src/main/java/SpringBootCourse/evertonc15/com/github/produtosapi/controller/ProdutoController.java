package SpringBootCourse.evertonc15.com.github.produtosapi.controller;

import SpringBootCourse.evertonc15.com.github.produtosapi.model.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Vai Receber operações rest's
@RequestMapping("produtos") //Vai dizer qual url que vai ser
public class ProdutoController {

    @PostMapping //Salvar o recurso no servidor
    public Produto salvarProduto(@RequestBody/*Objeto que vai vim do body da requisição*/ Produto produto){
        System.out.println("Produto Salvo: " + produto);
        return produto;
    }


}
