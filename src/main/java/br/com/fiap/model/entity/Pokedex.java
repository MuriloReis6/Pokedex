package br.com.fiap.model.entity;

import br.com.fiap.model.dto.PokedexDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Pokedex")
@Table(name = "dddj_pokedex")

public class Pokedex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private Double altura;
    private Double peso;
    private String tipo;
    private LocalDate dataDeCaptura;
    private String urlImagem;

    public Pokedex() {
    }

    //construtor com parametros

    public Pokedex(PokedexDTO pokedexDTO) {
        this.nome = pokedexDTO.nome();
        this.altura = pokedexDTO.altura();
        this.peso = pokedexDTO.peso();
        this.tipo = pokedexDTO.tipo();
        this.dataDeCaptura = pokedexDTO.dataDeCaptura();
        this.urlImagem = pokedexDTO.urlImagem();

    }

    //metodos getters e setters

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataDeCaptura() {
        return dataDeCaptura;
    }

    public void setDataDeCaptura(LocalDate dataDeCaptura) {
        this.dataDeCaptura = dataDeCaptura;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
