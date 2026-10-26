package br.com.fiap.model.repository;

import br.com.fiap.model.entity.Pokedex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokedexRepository extends JpaRepository<Pokedex, Long> {
    Pokedex findByCodigo(long codigo);
}
