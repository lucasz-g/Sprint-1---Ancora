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

    public void exibirProdutos(Estoque estoque){
        estoque.listarProdutos();
    }

    public void buscarProduto(Estoque estoque, String nome){
        estoque.buscarProdutoPorNome(nome);
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
