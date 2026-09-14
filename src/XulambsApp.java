import java.util.LinkedList;
import java.util.List;

public class XulambsApp {
    private List<Pizza> listaPizzas;

    private void limparTela() {
        IO.print("\033[H\033[2J");
    }

    private void pausa(){
        IO.readln("Digite <ENTER> para continuar");
        limparTela();
    }

    private void cabecalho(){
        limparTela();
        IO.println("XULAMBS PIZZA - v0.11");
        IO.println("=====================");
        IO.println("Pizzas vendidas hoje: " +
                    Pizza.getPizzasVendidas());
    }

    void abrirPedido() {
        String querMais = "n";
        Pedido novoPedido = new Pedido();

        do {
            Pizza novaPizza = comprarPizza();
            novoPedido.adicionarPizza(novaPizza);
            querMais = IO.readln("Quer mais pizzas? ");
        } while (querMais.equals("s"));
    }

    private int exibirMenu() {
        cabecalho();

        IO.println("1 - Abrir pedido");
        IO.println("2 - Alterar pedido");
        IO.println("3 - Relatório de pedido");
        IO.println("4 - Encerrar pedido");
        IO.println("0 - Sair");

        return Integer.parseInt(IO.readln("Digite sua opção: "));
    }

    void alteraPedido() {
        cabecalho();

        int idPedido = Integer.parseInt(IO.readln("Número do pedido: "));

        String busca = String.format("Pedido número %d", idPedido);

        for (Pedido p : listaPedidos) {
            if (p.relatorio().contains(busca)) // busca
        }
    }

    Pizza comprarPizza(){
        cabecalho();

        int adicionais = 
            Integer.parseInt(IO.readln("Quantos ingredientes? "));
    
        Pizza nova = new Pizza();
        nova.adicionarIngredientes(adicionais);

        mostrarNota(nova);
        return nova;
    }

    void mostrarNota(Pizza pizza){
        IO.println("Pizza comprada:");
        IO.println(pizza.gerarCupom());
        IO.println("=====================");
    }

    void mostrarPizzas(){
        cabecalho();

        for (Pizza pizza : listaPizzas) {
            mostrarNota(pizza);
        }
    }

    void main(){
        int opcao;
        listaPizzas = new LinkedList<>();

        do {
            opcao = exibirMenu();

            switch (opcao) {
                case 1 -> comprarPizza();
                case 2 -> mostrarPizzas();
                case 0 -> IO.println("Encerrando!");
                default -> IO.println("Opção inválida");
            }  

            pausa(); 
        } while (opcao != 0);
        

    }

    
}
