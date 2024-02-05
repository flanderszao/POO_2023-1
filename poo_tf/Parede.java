public class Parede extends ElementoBasico {

    public Parede(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
    }

    @Override
    public void acao(ElementoBasico outro) {
        return;
    }

    @Override
    public boolean getFlag() {
        return false;
    }
    
}
