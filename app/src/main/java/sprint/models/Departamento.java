package sprint.models;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nomeDepartamento;
    private String descricao;
    private List<Mecanico> mecanicos;
    private Admin gerente;
    private List<Servico> servicos;

    public Departamento(String nomeDepartamento, String descricao, Admin gerente) {
        this.nomeDepartamento = nomeDepartamento;
        this.descricao = descricao;
        this.gerente = gerente;
        gerente.setDepartamento(this);
        this.mecanicos = new ArrayList<>(); 
        this.servicos = new ArrayList<>();
    }

    public void adicionarMecanico(Mecanico mecanico) {
        if (mecanico != null) {
            boolean existe = false;
            for (Mecanico m : mecanicos) {
                if(m.getId() == mecanico.getId()){
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                mecanicos.add(mecanico);
                mecanico.setDepartamento(this);
                System.out.println("Mecanico adicionado");
            }else{
                System.out.println("Mecanico já existe");
            }
        } else {
            System.out.println("Mecânico não pode ser nulo.");
        }
    }

    public void adicionarServico(String nome, double preco){
        Servico servico = new Servico(nome, preco);
        servicos.add(servico);
        servico.setDepartamento(this);
    }

    public void listarServicos() {
        System.out.println("Serviços disponíveis no departamento " + nomeDepartamento + ":");
        for (Servico servico : servicos) {
            servico.exibirInfo();
        }
    }

    public void exibirInfo(){
        System.out.println("Departamento: " + nomeDepartamento);
        System.out.println("Descrição: " + descricao);
        System.out.println("Gerente: " + gerente.getNome());
        listarServicos();
    }

    // Getters e Setters
    public Admin getGerente() {
        return gerente;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(List<Mecanico> mecanicos) {
        this.mecanicos = mecanicos;
    }

}
