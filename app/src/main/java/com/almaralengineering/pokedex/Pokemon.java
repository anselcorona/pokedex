package com.almaralengineering.pokedex;

public class Pokemon {
    private final int soundId;
    private String id;
    private String name;
    private Type type;
    private int imageId;

    public enum Type {
        FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String name, Type type, int imageId, int soundId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.imageId = imageId;
        this.soundId = soundId;
    }

    public int getSoundId() {
        return soundId;
    }

    public int getImageId(){ return imageId; }

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
