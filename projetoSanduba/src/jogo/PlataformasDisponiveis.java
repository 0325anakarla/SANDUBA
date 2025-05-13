package jogo;

public enum PlataformasDisponiveis {

    XBOX("Xbox Series"),
    XBOX1("Xbox One"),
    PS4("PlayStation 4"),
    PS5("PlayStation 5"),
    NINTENDO("Nintendo Switch"),
    WINDOWS("Windows"),
    MACOS("MAC Os"),
    IOS("IOS"),
    LINUX("Linux"),
    ANDROID("Android");

    private String plataforma;

    PlataformasDisponiveis(String plataforma){
        this.plataforma = plataforma;
    }

    public String getPlataforma(){
        return this.plataforma;
    }

    public static void imprimePlataformas() {
        PlataformasDisponiveis[] plataformas = PlataformasDisponiveis.values();
        for (int i = 0; i < plataformas.length; i += 2) {

            System.out.print(i + ": " + plataformas[i].getPlataforma());

            if (i + 1 < plataformas.length) {
                System.out.print(" | " + (i + 1) + ": " + plataformas[i + 1].getPlataforma());
            }

            System.out.println();
        }
    }

}
