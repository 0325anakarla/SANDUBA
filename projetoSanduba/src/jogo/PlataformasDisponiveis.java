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

    public static void imprimePlataformas(){
        int i = 0;
        for (PlataformasDisponiveis plataforma : PlataformasDisponiveis.values()) {
            System.out.println(i + ": " + plataforma.getPlataforma());
            i++;
        }
    }

}
