package sprint.models;

public class Servico {
    private static int id = 0;
    private int idServico;
    private String nome;
    private double preco;
    private Departamento departamento;

    Servico(String nome, double preco) {
        idServico = ++ id;
        this.nome = nome;
        this.preco = preco;
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void exibirInfo() {
        System.out.println("Serviço: " + nome + ", Preço: R$ " + preco);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Servico.id = id;
    }

}
