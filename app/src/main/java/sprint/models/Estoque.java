package sprint.models;

import java.util.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sprint.services.ProdutoService;

public class Estoque {
    private Endereco endereco;
    private List<Produto> produtosEmEstoque;
    private Admin gerente;
    private final ProdutoService produtoService;

    public Estoque(Endereco endereco, Admin gerente) {
        this.gerente = gerente;
        this.endereco = endereco;
        this.produtosEmEstoque = new ArrayList<>();
        gerente.setEstoque(this);
        this.produtoService = new ProdutoService();
    }

    public void listarProdutos() {
        produtoService.buscarProdutos(new Callback<List<ProdutoJson>>() {
            @Override
            public void onResponse(Call<List<ProdutoJson>> call, Response<List<ProdutoJson>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ProdutoJson> listaDeJson = response.body();
            
                    for (ProdutoJson produtoJson : listaDeJson) {
                        Produto produto = new Produto(produtoJson.getId(), produtoJson.getTitle(), produtoJson.getPrice(), produtoJson.getDescription(), produtoJson.getCategory());
                        produtosEmEstoque.add(produto);
                    }
                    System.out.println("Produtos em Estoque: ");
                    for (Produto produto : produtosEmEstoque) {
                        produto.exibirInfo();
                    }

                } else {
                    System.out.println("Falha ao obter produtos: Resposta sem sucesso.");
                }
            }

            @Override
            public void onFailure(Call<List<ProdutoJson>> call, Throwable t) {
                System.out.println("Erro ao obter produtos: " + t.getMessage());
            }
        });
    }

    public void enderecoEstoque(){
        System.out.println("Endereço do estoque: ");
        System.out.println(endereco.getEnderecoCompleto());
    }

    // Getters e Setters
    public Admin getGerente() {
        return gerente;
    }

    public void setGerente(Admin gerente) {
        this.gerente = gerente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Produto> getProdutosEmEstoque() {
        return produtosEmEstoque;
    }

    public void setProdutosEmEstoque(List<Produto> produtosEmEstoque) {
        this.produtosEmEstoque = produtosEmEstoque;
    }
}
