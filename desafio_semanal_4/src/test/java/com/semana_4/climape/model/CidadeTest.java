package com.semana_4.climape.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CidadeTest {

    @Test
    void deveriaCriarUmaCidadeCorretamente() {
        Cidade cidadeTeste = new Cidade("TesteCity", 40.0, "Calor Infernal 🔥", "img/sol.png");

        assertEquals("TesteCity", cidadeTeste.getNome());
        assertEquals(40.0, cidadeTeste.getTemperatura());
        assertEquals("Calor Infernal 🔥", cidadeTeste.getDescricao());
        assertEquals("img/sol.png", cidadeTeste.getIcone());
    }
}