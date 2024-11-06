package sprint.models;

public class Admin {
    private String nome;
    private String contato;
    private Endereco endereco;
    private Departamento departamento;
    private Estoque estoque;

    public Admin(String nome, String contato, Endereco endereco) {
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;
    }

    public void cadastrarMecanico(Mecanico mecanico) {
        if (departamento != null) {
            departamento.adicionarMecanico(mecanico);
            mecanico.setDepartamento(departamento);
        } else {
            System.out.println("Departamento não atribuído ao administrador.");
        }
    }

    private Mecanico buscarMecanico(int id) {
        if (departamento != null) {
            for (Mecanico mecanico : departamento.getMecanicos()) {
                if (mecanico.getId() == id) {
                    return mecanico;
                }
            }
        }
        System.out.println("Mecânico não encontrado.");
        return null;
    }

    public void listarMecanicos(){
        if (departamento != null) {
            if (departamento.getMecanicos()  != null) {
                System.out.println("Lista de Mecanicos: ");
                for (Mecanico mecanico : departamento.getMecanicos()) {
                    mecanico.exibirInfo();
                }
            }
        }
    }

    public void aumentarSalario(int id, double valor){
        Mecanico mecanico = buscarMecanico(id);
        if (mecanico != null && mecanico.getExperiencia() > 1) {
            double total = mecanico.getSalario() + valor;
            mecanico.setSalario(total);
            System.out.println("Aumento de salario realizado.");
        }else{
            System.out.println("Não foi possível aumentar o salário do mecanico");
        }
    }

    //Getters e Setters
    public void exibirInfo(){
        System.out.println("Administrador: " + nome);
        System.out.println("Contato: " + contato);
        System.out.println("Endereço: " + endereco);
        System.out.println("Departamento: " + departamento);
        System.out.println("Estoque: " + estoque);

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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

}
