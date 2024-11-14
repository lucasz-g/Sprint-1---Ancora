package sprint.models;

import java.util.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sprint.services.ProdutoService;

public class Estoque {
    private static int id = 0;
    private int idEstoque;
    private Endereco endereco;
    private Admin gerente;
    private final ProdutoService produtoService;

    //Dynamic Programming
    private List<Produto> produtosEmEstoque; // Listar produtos disponiveis
    private Map<String, Produto> produtosPorNome; // Busca por nome
    private List<Produto> produtosOrdenadosPorPreco; // Cotação de preço
    private Queue<Produto> carrinhoDeCompras; // Processo de compra

    public Estoque(Endereco endereco, Admin gerente) {
        idEstoque = ++ id;
        this.gerente = gerente;
        this.endereco = endereco;
        this.produtosEmEstoque = new ArrayList<>();
        this.produtosPorNome = new HashMap<>();
        this.produtosOrdenadosPorPreco = new ArrayList<>();
        this.carrinhoDeCompras = new LinkedList<>();
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
                        produtosPorNome.put(produto.getNome(), produto);
                    }

                    atualizarProdutosOrdenadosPorPreco();

                    enderecoEstoque();
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

    private void atualizarProdutosOrdenadosPorPreco() {
        produtosOrdenadosPorPreco = new ArrayList<>(produtosEmEstoque);
        produtosOrdenadosPorPreco.sort(Comparator.comparing(Produto::getPreco));
    }

    public Produto buscarProdutoPorNome(String nome) {
        return produtosPorNome.get(nome);
    }

    public void exibirProdutosOrdenadosPorPreco() {
        System.out.println("Produtos ordenados por preço:");
        for (Produto produto : produtosOrdenadosPorPreco) {
            produto.exibirInfo();
        }
    }

    public void adicionarAoCarrinho(Produto produto) {
        carrinhoDeCompras.add(produto);
        System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
    }

    public void processarCompra() {
        System.out.println("Processando compra...");
        while (!carrinhoDeCompras.isEmpty()) {
            Produto produto = carrinhoDeCompras.poll();
            if (produtosEmEstoque.contains(produto)) {
                produtosEmEstoque.remove(produto);
                System.out.println("Comprando: " + produto.getNome());
            }else{
                System.out.println("Produto não encontrado em estoque: " + produto.getNome());
            }
        }
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
        atualizarProdutosOrdenadosPorPreco(); 
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Estoque.id = id;
    }
}