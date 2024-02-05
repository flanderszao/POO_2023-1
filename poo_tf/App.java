import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener{
    private Tabuleiro tabuleiro;
    private Personagem personagem;
    private Oponente oponente; //necessario para espelhar jogadas
    private Saida saida; //necessario para jogo em menos de 50 rodadas

    public App() {
        super();
        // Define os componentes da tela
        tabuleiro = new Tabuleiro();
        
        JPanel botoesDirecao = new JPanel(new FlowLayout());
        JButton butDir = new JButton("Direita");
        butDir.addActionListener(this);
        JButton butEsq = new JButton("Esquerda");
        butEsq.addActionListener(this);
        JButton butCima = new JButton("Acima");
        butCima.addActionListener(this);
        JButton butBaixo = new JButton("Abaixo");
        butBaixo.addActionListener(this);
        JButton butAcao = new JButton("Ação");
        butAcao.addActionListener(this);
        botoesDirecao.add(butEsq);
        botoesDirecao.add(butDir);
        botoesDirecao.add(butCima);
        botoesDirecao.add(butBaixo);
        botoesDirecao.add(butAcao);

        //JLabel labContador = new JLabel(tabuleiro.getCont()+"/50 passos dados.");
        
        JPanel painelGeral = new JPanel();
        painelGeral.setLayout(new BoxLayout(painelGeral, BoxLayout.PAGE_AXIS));
        painelGeral.add(tabuleiro);
        painelGeral.add(botoesDirecao);

        //painelGeral.add(labContador) não funcional

        // Insere os personagens no tabuleiro
        personagem = new Personagem("Feliz","icone.jpg",3,1,tabuleiro);
        ElementoBasico anterior = tabuleiro.insereElemento(personagem);
        personagem.setAnterior(anterior);

        oponente = new Oponente("Infeliz", "oponente.jpg", 5, 2, tabuleiro); //criação de oponente
        anterior = tabuleiro.insereElemento(oponente);
        oponente.setAnterior(anterior);

        // GAMBIARRA PARA CRIAR PAREDES
        for(int i=0; i<11; i++){
            Parede parede = new Parede("parede", "fundo (parede).jpg", 0, i, tabuleiro);
            tabuleiro.insereElemento(parede);
            Parede parede2 = new Parede("parede", "fundo (parede).jpg", 10, i, tabuleiro);
            if(i!=5) tabuleiro.insereElemento(parede2);
            if(i<10 && i>0){
                Parede parede3 = new Parede ("parede", "fundo (parede).jpg", i, 0, tabuleiro);
                tabuleiro.insereElemento(parede3);
                Parede parede4 = new Parede("parede", "fundo (parede).jpg", i, 10, tabuleiro);
                tabuleiro.insereElemento(parede4);
                Parede parede5 = new Parede ("parede", "fundo (parede).jpg", i, 1, tabuleiro);
                Parede parede6 = new Parede ("parede", "fundo (parede).jpg", i, 9, tabuleiro);
                if (i>3&&i<10){
                    tabuleiro.insereElemento(parede5);
                    tabuleiro.insereElemento(parede6);
                }
                Parede parede7 = new Parede ("parede", "fundo (parede).jpg", 4, i, tabuleiro);
                if (i>1 && i<9 && i!=5) tabuleiro.insereElemento(parede7);
                Parede parede8 = new Parede ("parede", "fundo (parede).jpg", i, 4, tabuleiro);
                Parede parede9 = new Parede ("parede", "fundo (parede).jpg", i, 6, tabuleiro);
                if ((i>1 && i<5)||(i>5 && i<9)){
                    tabuleiro.insereElemento(parede8);
                    tabuleiro.insereElemento(parede9);
                }
                Parede parede10 = new Parede ("parede", "fundo (parede).jpg", i, 3, tabuleiro);
                Parede parede11 = new Parede ("parede", "fundo (parede).jpg", i, 7, tabuleiro);
                if (i>5 && i<9) {
                    tabuleiro.insereElemento(parede10);
                    tabuleiro.insereElemento(parede11);
                }
            }
        }
        
        //INSERIR ELEMENTOS DO LABIRINTO
        Chave chave = new Chave("chave", "fundo (item).jpg", 3, 7, tabuleiro);
        tabuleiro.insereElemento(chave);

        PortaChave portaChave = new PortaChave("portaChave", "fundo (trancada).jpg", 4, 5, tabuleiro, chave.getLin(), chave.getCol());
        tabuleiro.insereElemento(portaChave);

        Porta porta = new Porta("porta", "fundo (porta).jpg", 1, 4, tabuleiro);
        tabuleiro.insereElemento(porta);

        Placa placa = new Placa("placa", "fundo (placa).jpg", 1, 9, tabuleiro);
        tabuleiro.insereElemento(placa);

        Armadilha armadilha1 = new Armadilha("armadilha1", "fundo (caminho 1).jpg", 7, 2, tabuleiro);
        tabuleiro.insereElemento(armadilha1);

        Armadilha armadilha2 = new Armadilha("armadilha2", "fundo (caminho 2).jpg", 7, 5, tabuleiro);
        tabuleiro.insereElemento(armadilha2);

        Fundo caminho3 = new Fundo("caminho3", 7, 8, tabuleiro);
        caminho3.setImage(new ImageIcon("fundo (caminho 3).jpg"));
        tabuleiro.insereElemento(caminho3);

        saida = new Saida("saida", "fundo (saida).jpg", 10, 5, tabuleiro);
        tabuleiro.insereElemento(saida);

        // Exibe a janela
        this.add(painelGeral);

        this.setSize(450,600);
        this.setTitle("Jogo de Escape");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        tabuleiro.atualizaVisualizacao();
    }

    public void oponenteAcao(){ //para movimentação do oponente
        saida.setCont(1);
        if (saida.getCont()==50){
            saida.acao(null);
        }
        if(oponente.getCont()<7){
            oponente.moveDireita();
             oponente.setCont(oponente.getCont()+1);
        }
        if(oponente.getCont()>6){
            oponente.moveEsquerda();
            oponente.setCont(oponente.getCont()+1);
        }
        if (oponente.getCont()==13) oponente.setCont(0);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JButton but = (JButton)arg0.getSource();
        
        if (but.getText().equals("Direita")){
            personagem.moveDireita();
        }
        if (but.getText().equals("Esquerda")){
            personagem.moveEsquerda();
        }
        if (but.getText().equals("Acima")){
            personagem.moveCima();
        }
        if (but.getText().equals("Abaixo")){
            personagem.moveBaixo();
        }
        if (but.getText().equals("Ação")){
            personagem.acaoContexto();
        }
        oponenteAcao();

        tabuleiro.atualizaVisualizacao();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}