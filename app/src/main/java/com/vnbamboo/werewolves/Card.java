package com.vnbamboo.werewolves;

public class Card {
    private int id;
    private int numOrder;
    private String name;
    private String path;

    public Card( int id, int numOrder, String name, String path ) {
        this.id = id;
        this.numOrder = numOrder;
        this.name = name;
        this.path = path;
    }

    public Card( int id, String name, String path ) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.numOrder = 0;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public int getNumOrder() {
        return numOrder;
    }

    public void setNumOrder( int numOrder ) {
        this.numOrder = numOrder;
    }

    public void setPath( String path ) {
        this.path = path;

    }
}
