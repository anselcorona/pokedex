package com.almaralengineering.pokedex;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PokemonListFragment.OnFragmentInteractionListener, View.OnClickListener {

    private static final int OPTION_DETAIL = 0;
    private static final int OPTION_STATS = 1;

    private Fragment current;
    private Pokemon selectedPokemon;
    private int selectedOption;
    TextView imageTextButton;
    TextView statsTextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageTextButton = (TextView) findViewById(R.id.text_button_image);
        statsTextButton = (TextView) findViewById(R.id.text_button_stats);

        imageTextButton.setOnClickListener(this);
        statsTextButton.setOnClickListener(this);
        imageTextButton.setBackgroundColor(getResources().getColor(R.color.display_selected));
        statsTextButton.setBackgroundColor(getResources().getColor(R.color.display_not_selected));
        selectedOption=0;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.text_button_image:
                imageTextButton.setBackgroundColor(getResources().getColor(R.color.display_selected));
                statsTextButton.setBackgroundColor(getResources().getColor(R.color.display_not_selected));
                selectedOption=0;
                break;
            case R.id.text_button_stats:
                statsTextButton.setBackgroundColor(getResources().getColor(R.color.display_selected));
                imageTextButton.setBackgroundColor(getResources().getColor(R.color.display_not_selected));
                selectedOption=1;
                break;
        }
        setFragmentAndContent();
    }
    private void setFragmentAndContent(){
        if(selectedPokemon!=null){
            if(selectedOption==OPTION_DETAIL){
                current = DetailFragment.newInstance(selectedPokemon.getImageurl(),selectedPokemon.getSoundId());
            }
            else if(selectedOption==OPTION_STATS){
                current = StatsFragment.newInstance(selectedPokemon.getStats());
            }

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.replace(R.id.detail_fragment_container, current);

            fragmentTransaction.commit();
        } else {
            Toast.makeText(getApplicationContext(), "DEBES SELECCIONAR UN POKEMON PRIMERO", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPokemonSelected(Pokemon pokemon) {
        selectedPokemon = pokemon;
        setFragmentAndContent();
    }
}
