package com.example.revisao.views.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Musica implements Parcelable {
    private String nomeMusica;
    private int imagemMusica;

    public Musica(String nomeMusica, int imagemMusica) {
        this.nomeMusica = nomeMusica;
        this.imagemMusica = imagemMusica;
    }

    public Musica() {
    }

    protected Musica(Parcel in) {
        nomeMusica = in.readString();
        imagemMusica = in.readInt();
    }

    public static final Creator<Musica> CREATOR = new Creator<Musica>() {
        @Override
        public Musica createFromParcel(Parcel in) {
            return new Musica(in);
        }

        @Override
        public Musica[] newArray(int size) {
            return new Musica[size];
        }
    };

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public int getImagemMusica() {
        return imagemMusica;
    }

    public void setImagemMusica(int imagemMusica) {
        this.imagemMusica = imagemMusica;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomeMusica);
        dest.writeInt(imagemMusica);
    }
}
