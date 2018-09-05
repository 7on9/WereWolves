package com.vnbamboo.werewolves;

public class Card {
    private byte id;
    private byte numOrder;
    private String name;
    private String path;

    public Card( byte id, byte numOrder, String name, String path ) {
        this.id = id;
        this.numOrder = numOrder;
        this.name = name;
        this.path = path;
    }

    public Card( byte id, String name, String path ) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.numOrder = 0;
    }

    public byte getId() {
        return id;
    }

    public void setId( byte id ) {
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

    public byte getNumOrder() {
        return numOrder;
    }

    public void setNumOrder( byte numOrder ) {
        this.numOrder = numOrder;
    }

    public void setPath( String path ) {
        this.path = path;

    }
}
