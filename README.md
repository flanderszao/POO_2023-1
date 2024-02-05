README POO_TF
# Nome do Projeto: Jogo de Escape
# Versão: 1.0.2 (jogável e estável)
# Autor: Vitor Rafael Borges

### Classes criadas

Classes que estendem de ElementoBasico:
- Armadilha
- Chave
- Parede
- Placa
- Porta

Classes que estendem de outras classes:
- PortaChave (> Porta)
- Saida (> Armadilha)
- Oponente (> Personagem)

## Regras do Jogo E Usabiliade

O jogador possui movimentação para cima, baixo, esquerda e direita, além de um botão de ação contextual. \\(Que cá entre nós, acabou sendo inútil)\\
Quando o Jogador se movimenta em uma direção que há um *ELEMENTO* ele tentará interagir com o elemento se possível, também é possível tentar uma interação utilizando o botão de ação.

O jogador deve chegar até a *PORTA DE SAÍDA* em até 50 jogadas, o jogador deve prestar atenção ao navegar o mapa, e deve evitar *ARMADILHAS* e evadir o *OPONENTE* para que o jogo não acabe prematuramente.

Toda vez que o personagem faz uma ação (mesmo que tentativamente) o contador de jogada sobe e o oponente se movimenta.

O personagem tem prioridade em ações comparado ao oponente.

O jogador pode abrir *PORTAS*, coletar *CHAVE* para porta que esteja *TRANCADA*, e pode ler *PLACA* que possui informação para auxiliar na tomada de decisões.
