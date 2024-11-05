package sprint.models;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private String descricao;
    private Categoria categoria;

   public Produto(int id, String nome, double preco, String descricao, String categoria){
       this.nome = nome;
       this.preco = preco;
       this.descricao = descricao;
       this.categoria = new Categoria(categoria);
   }

   public void exibirInfo(){
        System.out.println("Nome: " + nome);
        System.out.println("Preco: " + preco);
        System.out.println("Descricao: " + descricao);
        System.out.println("Categoria: " + categoria.getNomeCategoria());
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}