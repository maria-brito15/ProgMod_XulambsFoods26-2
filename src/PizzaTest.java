import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class PizzaTest {

    private Pizza pizza;

    @BeforeEach
    public void setUp() {
        pizza = new Pizza();
        pizza.adicionarIngredientes(2);
    }

    @Test
    public void adicionaIngredientesCorretamente() {
        // Act
        int quantos = pizza.adicionarIngredientes(4);

        // Assert
        assertEquals(6, quantos);
    }

    @Test
    public void naoadicionaIngredientesCorretamente() {
        // Act
        int quantidade = pizza.adicionarIngredientes(-5);

        // Assert
        assertEquals(2, quantidade);
    }

    @Test
    public void naoUltrapassarMaximoDeIngredientes() {
        // Act
        int quantidde = pizza.adicionarIngredientes(7);
        // Assert
        assertEquals(2, quantidde);
    }

    @Test
    public void calcularOPrecoCorretamente() {
        // Act
        double preco = pizza.calcularValorFinal();
        // Assert
        assertEquals(39, preco, 0.01);

    }
}