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

    /*public static void imprimeIdiomas(){
        int i = 0;
        for (Idiomas idioma : Idiomas.values()) {
            System.out.println(i + ": " + idioma.getIdioma());
            i++;
        }
    }*/
    
    public static void imprimeIdiomas() {
        Idiomas[] idiomas = Idiomas.values();
        StringBuilder sb = new StringBuilder();
        
        System.out.println("🌐 ESCOLHA OS IDIOMAS DISPONÍVEIS:");
        
        for (int i = 0; i < idiomas.length; i++) {
            sb.append(i).append(": ").append(idiomas[i].getIdioma());
            if (i < idiomas.length - 1) {
                sb.append(" | ");
            }
        }

        System.out.println(sb.toString());
    }

}
