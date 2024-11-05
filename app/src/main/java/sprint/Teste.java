/*
 * This source file was generated by the Gradle 'init' task
 */
package sprint;

import sprint.models.Admin;
import sprint.models.Departamento;
import sprint.models.Endereco;
import sprint.models.Estoque;
import sprint.models.Mecanico;

public class Teste {
    
    public static void main(String[] args) {
        Endereco endereco = new Endereco("Av Paulista", "Sao Paulo", "Sao Paulo", "000999");
        Mecanico mecanico = new Mecanico("Lucas", "0099999", 2 ,endereco);
        Admin administrador = new Admin("Jair", "922222", endereco);
        Departamento departamento = new Departamento("Peças", "Tratamento de peças", administrador);
        Estoque estoque = new Estoque(endereco, administrador);

        administrador.cadastrarMecanico(mecanico);
        administrador.listarMecanicos();

        departamento.adicionarServico("Manutenção", 200);
        departamento.listarServicos();

        mecanico.buscarProdutos(estoque);
    }
}