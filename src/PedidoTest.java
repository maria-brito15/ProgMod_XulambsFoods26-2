import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    Pedido pedido;
    Pizza pizzaVazia;

    @BeforeEach 
    public void setUp() {
        pedido = new Pedido();
        pizzaVazia = new Pizza();
        pedido.adicionarPizza(pizzaVazia);
    }

    @Test
    public void adicionarPizzaCorretamente() {
        // Act
        int quantidade = pedido.adicionarPizza(new Pizza());

        // Assert
        assertEquals(2, quantidade);
    }
    
    @Test
    public void naoAdicionaPizzaEmPedidoFechado(){
        //Arrange
        Pedido pedido = new Pedido();
        pedido.adicionarPizza(new Pizza());
        pedido.fecharPedido();

        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
    
        //Assert
        assertEquals(1, quantidade);
    }

    @Test 
    public void calculaValorPedidoCorretamente() {
        double preco = pedido.precoAPagar();
        assertEquals(29d, preco, 0.01);
    }

    @Test
    public void calcularPrecoDePedidosComVariasPizzas() {
        // Arrange
        Pedido pedido = new Pedido();

        Pizza pizza1 = new Pizza(1);
        Pizza pizza2 = new Pizza(4);
        Pizza pizza3 = new Pizza(7);
 
        pedido.adicionarPizza(pizza1);
        pedido.adicionarPizza(pizza2);
        pedido.adicionarPizza(pizza3);

        // Act
        double preco = pedido.precoAPagar();

        // Assert
        assertEquals(147d, preco, 0.01);
    }

    @Test
    public void gerarRelatorioDePedido() {
        //Act
        String cupom = pedido.relatorio();

        //Assert
        assertTrue(
            cupom.contains("29,00") &&
            cupom.contains("1 pizza") &&
            cupom.contains("aberto")
        );
    }
}
