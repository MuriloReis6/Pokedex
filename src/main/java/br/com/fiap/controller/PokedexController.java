package br.com.fiap.controller;

import br.com.fiap.model.dto.PokedexDTO;
import br.com.fiap.model.entity.Pokedex;
import br.com.fiap.model.repository.PokedexRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/pokedex")
public class PokedexController {

    @Autowired
    private PokedexRepository pokedexRepository;

    @GetMapping("/novo")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView("formulario");
        return mv;
    }

    @PostMapping
    public ModelAndView cadastrar(@Valid PokedexDTO pokedexDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/pokedex");
        }
        Pokedex pokedex = new Pokedex(pokedexDTO);
        pokedexRepository.save(pokedex);
        ModelAndView mv = new ModelAndView("redirect:/pokedex");
        return mv;
    }

    @GetMapping
    public ModelAndView consultar() {
        List<Pokedex> pokedex = pokedexRepository.findAll();
        ModelAndView mv = new ModelAndView("pokedex"); //o thymeleaf encontra a pasta templates em resources por padrão, então não precisa colocar o caminho completo
        mv.addObject("pokedex", pokedex);
        return mv;
    }

    @GetMapping("/{codigo}")
    public ModelAndView buscarPorCodigo(@PathVariable("codigo") Long codigo) {
        Pokedex pokedex = pokedexRepository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("pokedex", pokedex);
        mv.addObject("acao", "/pokedex/atualizar/" + codigo);
        return mv;
    }

    @GetMapping ("/excluir/{codigo}")
    public ModelAndView excluir(@PathVariable("codigo") Long codigo) {
        pokedexRepository.deleteById(codigo);
        ModelAndView mv = new ModelAndView("redirect:/pokedex");
        return mv;
    }

    @GetMapping("/editar/{codigo}")
    public ModelAndView consultarPorCodigo(@PathVariable("codigo") Long codigo) {
        Pokedex pokedex = pokedexRepository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("pokedex", pokedex);
        mv.addObject("acao", "/pokedex/atualizar/"+codigo);
        return mv;
    }

    @PostMapping("/atualizar/{codigo}")
    public ModelAndView atualizar(@PathVariable("codigo") Long codigo,
                                  @Valid PokedexDTO pokedexDTO,
                                  BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/pokedex");
        }
        Pokedex pokedex = new Pokedex(pokedexDTO);
        pokedex.setCodigo(codigo);
        pokedexRepository.save(pokedex);
        ModelAndView mv = new ModelAndView("redirect:/pokedex");
        return mv;
    }
}
