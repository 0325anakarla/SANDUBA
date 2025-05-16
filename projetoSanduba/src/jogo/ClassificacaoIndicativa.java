package jogo;

public enum ClassificacaoIndicativa {

    LIVRE("L - Livre para todos os públicos."),
    ANOS10("10 - Não recomendado para menores de 10 anos."),
    ANOS12("12 - Não recomendado para menores de 12 anos."),
    ANOS14("14 - Não recomendado para menores de 14 anos."),
    ANOS16("16 - Não recomendado para menores de 16 anos."),
    ANOS18("18 - Não recomendado para menores de 18 anos.");

    private String classificacaoInd;

    ClassificacaoIndicativa(String classificacaoInd){
        this.classificacaoInd = classificacaoInd;
    }

    public String getClassificacao(){
        return this.classificacaoInd;
    }

    /*public static void imprimeClassificacoes(){
        int i = 0;
        for (ClassificacaoIndicativa classificacao : ClassificacaoIndicativa.values()) {
            System.out.println(i + ": " + classificacao.getClassificacao());
            i++;
        }
    }*/
    public int getIdadeMinima() {
    	switch (this) {
        case ANOS10: return 10;
        case ANOS12: return 12;
        case ANOS14: return 14;
        case ANOS16: return 16;
        case ANOS18: return 18;
        default: return 0; // Caso seja LIVRE
    }
    }
    
    public static void imprimeClassificacoes() {
       System.out.println("📋 ESCOLHA AS CLASIFICAÇÕES INDICATIVAS:");

        ClassificacaoIndicativa[] classificacoes = ClassificacaoIndicativa.values();
        for (int i = 0; i < classificacoes.length; i++) {
            System.out.printf(" %2d: %-20s%n", i, classificacoes[i].getClassificacao());
        }
    }
}
