package br.com.fiap.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record PokedexDTO(

    @NotBlank
    String nome,
    @NotBlank
    String tipo,
    @NotNull
    @PositiveOrZero
    Double altura,
    @NotNull
    @PositiveOrZero
    Double peso,
    @PastOrPresent
    LocalDate dataDeCaptura,
    String urlImagem
) {
}
