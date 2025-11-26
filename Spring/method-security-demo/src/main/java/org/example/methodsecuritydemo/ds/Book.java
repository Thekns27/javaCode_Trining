package org.example.methodsecuritydemo.ds;

public class Book {
    private String neme;
    private String owner;

    public void setNeme(String neme) {
        this.neme = neme;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getNeme() {
        return neme;
    }

    public String getOwner() {
        return owner;
    }

    public Book(String neme, String owner) {
        this.neme = neme;
        this.owner = owner;
    }
}
