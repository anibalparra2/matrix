package com.example.matrix.repositorio;

public class DataIn {

    private String searchword;
    private int rows;
    private String word;

    public DataIn(String searchword, int rows, String word) {
        this.searchword = searchword;
        this.rows = rows;
        this.word = word;
    }

    public String getSearchword() {
        return searchword;
    }

    public void setSearchword(String searchword) {
        this.searchword = searchword;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "DataIn{" +
                "searchword='" + searchword + '\'' +
                ", rows=" + rows +
                ", word='" + word + '\'' +
                '}';
    }
}
