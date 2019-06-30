package trabalhooo.gui;

public interface GuiListener {
    /**
     * Evento de uma jogada feita por um Jogador
     * @param nomeJogador Nome do jogador que fez a jogada
     * @param nomeCartaJogada Nome da carta jogada, vazia se passou a rodada
     */
    public void jogadaFeita(String nomeJogador, String nomeCartaJogada);
}