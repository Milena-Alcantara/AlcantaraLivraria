package model;

public class BookModel {
    private int id_book;
    private String title;
    private String synthesis;
    private String genrer;
    private Boolean statusBook;
    private int id_autor;

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynthesis() {
        return synthesis;
    }

    public void setSynthesis(String synthesis) {
        this.synthesis = synthesis;
    }

    public String getGenrer() {
        return genrer;
    }

    public void setGenrer(String genrer) {
        this.genrer = genrer;
    }

    public Boolean getStatusBook() {
        return statusBook;
    }

    public void setStatusBook(Boolean statusBook) {
        this.statusBook = statusBook;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }
}
