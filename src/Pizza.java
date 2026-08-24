public class Pizza {
    static final double PRECO_BASE;
    static final int MAXIMO_INGREDIENTES;
    static final double VALOR_INGREDIENTE;

    static int pizzasVendidas;
    final String descricao;

    int quantidadeIngredientes;

    static {
        PRECO_BASE = 29;
        MAXIMO_INGREDIENTES = 8;
        VALOR_INGREDIENTE = 5;
        pizzasVendidas = 0;
    }

    void init(int adicionais) {
        adicionarIngredientes(adicionais);
        pizzasVendidas++;
    }

    public Pizza() {
        init(0);
        descricao = "Pizza sem adicionais";
    }

    public Pizza(int adicionais) {
        init(adicionais);
        descricao = "Pizza com " + adicionais + " ingredientes";
    }

    public double calcularValorFinal() {
        return PRECO_BASE + calcularValorAdicionais();
    }

    public double calcularValorAdicionais() {
        return quantidadeIngredientes * VALOR_INGREDIENTE;
    }

    public String gerarCupom() {
        String cupom = "Xulambs Pizza!!!\n";

        cupom += String.format("Pizza com %d ingredientes\n", quantidadeIngredientes);

        cupom += String.format("\tPreço base: R$ %.2f\n", PRECO_BASE);
        cupom += String.format("\tAdicionais: R$ %.2f\n", calcularValorAdicionais());
        cupom += String.format("VALOR A PAGAR: R$ %.2f", calcularValorFinal());

        return cupom;
    }

    /**
     * Verifica se a quantidade de ingredientes passada pode
     * ser adicionada na pizza, retornando true/false
     * confore o resultado.
     * 
     * @param quantidade Ingredientes a serem adicionados
     * @return TRUE se a quantidade for >=0 e o total <=8, FALSE para casos
     *         contrários.
     */
    public boolean podeAdicionar(int quantidade) {
        return quantidade >= 0
                && quantidade + quantidadeIngredientes <= MAXIMO_INGREDIENTES;
    }

    public int adicionarIngredientes(int quantidade) {
        if (podeAdicionar(quantidade)) {
            quantidadeIngredientes += quantidade;
        }
        return quantidadeIngredientes;
    }
}