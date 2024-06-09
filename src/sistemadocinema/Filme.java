package sistemadocinema;

import java.time.LocalDate;

/**
 * A classe Filme representa um filme exibido no cinema, herdando propriedades de Produto.
 * Inclui informações específicas sobre o título, estilo e período de exibição do filme.
 * 
 * @author Osiel Junior
 */
public class Filme extends Produto {
    private String titulo;
    private String estilo;
    private String periodoExibicao;
    private static int contadorProdutos = 0;

    /**
     * Construtor da classe Filme.
     * @param titulo O título do filme.
     * @param estilo O estilo do filme.
     * @param dataValidade A data de validade do filme.
     * @param valor O valor do filme.
     * @param quantidadeEmEstoque A quantidade disponível em estoque do filme.
     * @param periodoExibicao O período de exibição do filme.
     */
    public Filme(String titulo, String estilo, LocalDate dataValidade, double valor, int quantidadeEmEstoque, String periodoExibicao) {
        super(titulo, dataValidade, valor, quantidadeEmEstoque);
        this.titulo = titulo;
        this.estilo = estilo;
        this.periodoExibicao = periodoExibicao;
        contadorProdutos++;
    }

    /**
     * Obtém o título do filme.
     * @return O título do filme.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define o título do filme.
     * @param titulo O título do filme.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtém o estilo do filme.
     * @return O estilo do filme.
     */
    public String getEstilo() {
        return estilo;
    }

    /**
     * Define o estilo do filme.
     * @param estilo O estilo do filme.
     */
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    /**
     * Obtém o período de exibição do filme.
     * @return O período de exibição do filme.
     */
    public String getPeriodoExibicao() {
        return periodoExibicao;
    }

    /**
     * Define o período de exibição do filme.
     * @param periodoExibicao O período de exibição do filme.
     */
    public void setPeriodoExibicao(String periodoExibicao) {
        this.periodoExibicao = periodoExibicao;
    }

    /**
     * Obtém a quantidade total de produtos.
     * @return A quantidade total de produtos.
     */
    public static int getContadorProdutos() {
        return contadorProdutos;
    }

    /**
     * Define a quantidade total de produtos.
     * @param contadorProdutos A quantidade total de produtos.
     */
    public static void setContadorProdutos(int contadorProdutos) {
        Filme.contadorProdutos = contadorProdutos;
    }

    /**
     * Retorna uma representação em string do objeto.
     * @return Uma representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", estilo='" + estilo + '\'' +
                ", dataValidade=" + getDataValidade() +
                ", valor=" + getValor() +
                ", quantidadeEmEstoque=" + getQuantidadeEmEstoque() +
                ", periodoExibicao='" + periodoExibicao + '\'' +
                '}';
    }
}
