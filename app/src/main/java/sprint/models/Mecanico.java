package sprint.models;

public class Mecanico {
    private static int id = 0;
    private int idMecanico;
    private String nome;
    private String contato;
    private int experiencia;
    private double salario;
    private Endereco endereco;
    private Departamento departamento;

    public Mecanico(String nome, String contato, int experiencia, Endereco endereco) {
        this.idMecanico = ++id;
        this.nome = nome;
        this.contato = contato;
        this.experiencia = experiencia;
        this.endereco = endereco;
    }

    public void buscarProdutos(Estoque estoque){
        estoque.listarProdutos();
    }

    public void buscarProdutos(Estoque estoque, String criterio){
        estoque.listarProdutos();
        if(estoque.getProdutosEmEstoque() != null && !estoque.getProdutosEmEstoque().isEmpty()){
            boolean encontrado = false;
            for (Produto produto : estoque.getProdutosEmEstoque()) {
                if (produto.getNome().equals(criterio) || produto.getCategoria().getNomeCategoria().equals(criterio)) {
                    System.out.println("Produto encontrado");
                    System.out.println("Nome: " + produto.getNome());
                    System.out.println("Categoria: " + produto.getCategoria().getNomeCategoria());
                    encontrado = true;
                }
            }
            
            if(!encontrado){
                System.out.println("Produto não encontrado");
            }

        }else{
            System.out.println("Não há produtos em estoque");
        }
    }

    // Getters e Setters
    public void exibirInfo(){
        System.out.println("Id: " + idMecanico);
        System.out.println("Nome: " + nome);
        System.out.println("Contato: " + contato);
        System.out.println("Experiência: " + experiencia);
        System.out.println("Departamento: " + departamento.getNomeDepartamento());
    }

    public int getId() {
        return idMecanico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
