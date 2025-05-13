package jogo;

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

    public static void imprimeIdiomas(){
        int i = 0;
        for (Idiomas idioma : Idiomas.values()) {
            System.out.println(i + ": " + idioma.getIdioma());
            i++;
        }
    }
}
