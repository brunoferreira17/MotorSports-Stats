package org.motorsportstatscore.entity;

public class ResultadosFormula1 {
    private int posicao;
    private String pilotoNome;
    private String equipaNome;
    private String tempoFormatado;

    // Getters e Setters
    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getPilotoNome() {
        return pilotoNome;
    }

    public void setPilotoNome(String pilotoNome) {
        this.pilotoNome = pilotoNome;
    }

    public String getEquipaNome() {
        return equipaNome;
    }

    public void setEquipaNome(String equipaNome) {
        this.equipaNome = equipaNome;
    }

    public String getTempoFormatado() {
        return tempoFormatado;
    }

    public void setTempoFormatado(String tempoFormatado) {
        this.tempoFormatado = tempoFormatado;

    }
}
