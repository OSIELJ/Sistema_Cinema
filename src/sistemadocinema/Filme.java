/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;


import java.time.LocalDate;
/**
 *
 * @author Osiel Junior
 */
public class Filme extends Produto {
        private String titulo;
    private String estilo;
    private String periodoExibicao;

    public Filme(String titulo, String estilo, LocalDate dataValidade, double valor, int quantidadeEmEstoque, String periodoExibicao) {
        super(titulo, dataValidade, valor, quantidadeEmEstoque);
        this.titulo = titulo;
        this.estilo = estilo;
        this.periodoExibicao = periodoExibicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getPeriodoExibicao() {
        return periodoExibicao;
    }

    public void setPeriodoExibicao(String periodoExibicao) {
        this.periodoExibicao = periodoExibicao;
    }

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
