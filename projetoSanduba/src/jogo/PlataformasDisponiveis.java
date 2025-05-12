package jogo;

import java.util.ArrayList;
import java.util.List;

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

    ArrayList<PlataformasDisponiveis> platDispo = new ArrayList<PlataformasDisponiveis>(List.of(PlataformasDisponiveis.values()));

    public void imprimePlataformas(){
        for (PlataformasDisponiveis plataforma : platDispo) {
            System.out.println(plataforma.getPlataforma());
        }
    }

}
