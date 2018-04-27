package com.almaralengineering.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

public class Stats implements Parcelable {

    private String hp;
    private String Attack;
    private String Defense;
    private String Speed;

    public Stats(String HP, String attack, String defense, String speed) {
        this.hp = HP;
        Attack = attack;
        Defense = defense;
        Speed = speed;
    }

    public String getHp() {
        return hp;
    }

    public String getAttack() {
        return Attack;
    }

    public String getDefense() {
        return Defense;
    }

    public String getSpeed() {
        return Speed;
    }

    protected Stats(Parcel in) {
        hp = in.readString();
        Attack = in.readString();
        Defense = in.readString();
        Speed = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hp);
        dest.writeString(Attack);
        dest.writeString(Defense);
        dest.writeString(Speed);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Stats> CREATOR = new Parcelable.Creator<Stats>() {
        @Override
        public Stats createFromParcel(Parcel in) {
            return new Stats(in);
        }

        @Override
        public Stats[] newArray(int size) {
            return new Stats[size];
        }
    };
}