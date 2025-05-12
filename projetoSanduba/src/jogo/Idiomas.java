package jogo;

import java.util.ArrayList;
import java.util.List;

public enum Idiomas {

    INGLES("Ingles"),
    ESPANHOL("Espanhol"),
    ALEMAO("Alemão"),
    FRANCES("Francês"),
    RUSSO("Russo"),
    CHINES("Chinês"),
    PORTUGUES("Portugues");

    private String idioma;

    Idiomas(String idioma){
        this.idioma = idioma;
    }

    public String getIdioma(){
        return this.idioma;
    }

    ArrayList<Idiomas> idiomasDispo = new ArrayList<Idiomas>(List.of(Idiomas.values()));

    public void imprimeIdiomas(){
        for (Idiomas idioma : idiomasDispo) {
            System.out.println(idioma.getIdioma());
        }
    }
}
