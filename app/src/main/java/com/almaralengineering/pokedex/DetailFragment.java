package com.almaralengineering.pokedex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class DetailFragment extends Fragment {
    private ImageView detailImageView;


    public DetailFragment() {
        // Required empty public constructor
    }
    public static DetailFragment newInstance(String pokemonImageUrl, int pokemonSoundId) {

        Bundle args = new Bundle();

        args.putString("image", pokemonImageUrl);
        args.putInt("sound", pokemonSoundId);
        DetailFragment fragment = new DetailFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        detailImageView = (ImageView) view.findViewById(R.id.pokemon_detail_imageView);

        if(getArguments()!=null){
            String image = getArguments().getString("image");
            int sound = getArguments().getInt("sound");

            setPokemonImage(image);
            playPokemonSound(sound);
        }

        return view;
    }
    private void playPokemonSound(int soundId){
        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), soundId);
        mediaPlayer.start();
    }

    private void setPokemonImage(String pokemonImageUrl){
        Picasso.get().load(pokemonImageUrl).into(detailImageView);
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }

}
