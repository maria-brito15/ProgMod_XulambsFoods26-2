import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XulambsApp {
  static final Scanner leitor = new Scanner(System.in);
  static final List<Pizza> pizzasVendidas = new ArrayList<>();

  public static void main(String[] args) {
    int opcao;

    do {
      opcao = menuPrincipal();

      switch (opcao) {
        case 1 -> comprarPizza();
        case 2 -> mostrarPizzas();
        case 0 -> System.out.println("Encerrando!!");
        default -> System.out.println("Opção inválida.");
      }
    } while (opcao != 0);

    leitor.close();
  }

  private static void cabecalho() {
    System.out.println("Xulambs Pizza");
    System.out.println("-------------");
  }

  private static int menuPrincipal() {
    cabecalho();

    System.out.println("1 - Comprar pizza");
    System.out.println("2 - Ver pizzas vendidas");
    System.out.println("0 - Finalizar");
    System.out.print("Escolha uma opção: ");

    int opcao = lerInteiro();
    return opcao;
  }

  private static int lerInteiro() {
    while (!leitor.hasNextInt()) {
      System.out.print("Entrada inválida. Digite um número inteiro: ");
      leitor.next();
    }

    int valor = leitor.nextInt();
    leitor.nextLine();

    return valor;
  }

  private static void comprarPizza() {
    cabecalho();
    System.out.println("--- Comprar Pizza ---");

    List<Integer> adicionais = new ArrayList<>();
    escolherIngredientes(adicionais);

    Pizza novaPizza = new Pizza(adicionais.size());
    pizzasVendidas.add(novaPizza);

    System.out.println();
    System.out.println(novaPizza.gerarCupom());
  }

  private static void escolherIngredientes(List<Integer> adicionais) {
    System.out.println("Escolha os ingredientes adicionais (máximo 8):");
    System.out.println("Digite o número do ingrediente ou 0 para finalizar:");

    int ingrediente;

    do {
      System.out.print("Ingrediente (1-8, 0 para finalizar): ");
      ingrediente = lerInteiro();

      if (ingrediente >= 1 && ingrediente <= 8) {
        if (adicionais.size() < Pizza.MAXIMO_INGREDIENTES) {
          adicionais.add(ingrediente);
          System.out.println("Ingrediente adicionado.");
        } else {
          System.out.println("Máximo de ingredientes atingido.");
        }
      } else if (ingrediente != 0) {
        System.out.println("Ingrediente inválido. Tente novamente.");
      }

    } while (ingrediente != 0);
  }

  private static void mostrarPizzas() {
    cabecalho();
    System.out.println("--- Pizzas Vendidas ---");

    if (pizzasVendidas.isEmpty()) {
      System.out.println("Nenhuma pizza vendida ainda.");
      return;
    }

    for (int i = 0; i < pizzasVendidas.size(); i++) {
      Pizza pizza = pizzasVendidas.get(i);

      System.out.printf("Pizza %d:%n", i + 1);
      System.out.println(pizza.gerarCupom());
      System.out.println();
    }
  }
}