package com.almaralengineering.pokedex;

public class Pokemon {
    private final int soundId;
    private String id;
    private String name;
    private Type type;
    private String imageurl;

    public enum Type {
        FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String name, Type type, String imageurl, int soundId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.imageurl = imageurl;
        this.soundId = soundId;
    }

    public int getSoundId() {
        return soundId;
    }

    public String getImageurl(){ return imageurl; }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
