package com.almaralengineering.pokedex;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PokemonListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PokemonListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PokemonListFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    public PokemonListFragment() {
        // Required empty public constructor
    }

    public static PokemonListFragment newInstance() {
        PokemonListFragment fragment = new PokemonListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);

        ListView pokemonListView = (ListView) view.findViewById(R.id.pokemon_listView);
        Stats bulbasaurStats =  new Stats("22","33","44","55");
        Stats ivysaurStats   =  new Stats("22","33","44","55");
        Stats venusaurStats  =  new Stats("22","33","44","55");
        Stats charmanderStats=  new Stats("22","33","44","55");
        Stats charmeleonStats=  new Stats("22","33","44","55");
        Stats charizardStats =  new Stats("22","33","44","55");
        Stats squirtleStats  =  new Stats("22","33","44","55");
        Stats wartortleStats =  new Stats("22","33","44","55");
        Stats blastoiseStats =  new Stats("22","33","44","55");
        Stats pikachuStats   =  new Stats("22","33","44","55");
        Stats raichuStats    =  new Stats("22","33","44","55");
                ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(new Pokemon("1", "Bulbasaur", Pokemon.Type.PLANT, "http://cdn.bulbagarden.net/upload/thumb/1/19/Ash_Bulbasaur.png/245px-Ash_Bulbasaur.png", R.raw.bulbasaur, bulbasaurStats));
        pokemonList.add(new Pokemon("2", "Ivysaur", Pokemon.Type.PLANT,"http://vignette1.wikia.nocookie.net/es.pokemon/images/3/3a/EP893_Ivysaur_de_Xana_(2).png/revision/latest?cb=20151002171614", R.raw.ivysaur, ivysaurStats));
        pokemonList.add(new Pokemon("3", "Venusaur", Pokemon.Type.PLANT,"https://cdn.bulbagarden.net/upload/thumb/a/ae/003Venusaur.png/250px-003Venusaur.png", R.raw.venasaur, venusaurStats));
        pokemonList.add(new Pokemon("4", "Charmander", Pokemon.Type.FIRE,"http://cdn.bulbagarden.net/upload/thumb/7/75/Red_Charmander_PO.png/250px-Red_Charmander_PO.png", R.raw.charmander, charmanderStats));
        pokemonList.add(new Pokemon("5", "Charmeleon", Pokemon.Type.FIRE,"http://vignette2.wikia.nocookie.net/es.pokemon/images/6/66/EP778_Charmeleon_de_Ash.png/revision/latest?cb=20130311103442", R.raw.charmeleon, charmeleonStats));
        pokemonList.add(new Pokemon("6", "Charizard", Pokemon.Type.FIRE,"http://vignette2.wikia.nocookie.net/es.pokemon/images/e/e7/SME02_Charizard_de_Alain.png/revision/latest?cb=20151026181408", R.raw.charizard, charizardStats));
        pokemonList.add(new Pokemon("7", "Squirtle", Pokemon.Type.WATER,"http://cdn.bulbagarden.net/upload/thumb/8/8c/Tierno_Squirtle.png/250px-Tierno_Squirtle.png", R.raw.squirtle, squirtleStats));
        pokemonList.add(new Pokemon("8", "Wartortle", Pokemon.Type.WATER,"http://vignette1.wikia.nocookie.net/es.pokemon/images/c/c1/EP869_Wartortle_de_Benigno.png/revision/latest?cb=20150327182409", R.raw.wartortle, wartortleStats));
        pokemonList.add(new Pokemon("9", "Blastoise", Pokemon.Type.WATER,"http://cdn.bulbagarden.net/upload/thumb/0/05/Siebold_Mega_Blastoise.png/250px-Siebold_Mega_Blastoise.png", R.raw.blastoise, blastoiseStats));
        pokemonList.add(new Pokemon("25", "Pikachu", Pokemon.Type.ELECTRIC,"http://cdn.bulbagarden.net/upload/thumb/f/fd/Red_Pikachu_PO.png/220px-Red_Pikachu_PO.png", R.raw.pikachu, pikachuStats));
        pokemonList.add(new Pokemon("26", "Raichu", Pokemon.Type.ELECTRIC, "http://cdn.bulbagarden.net/upload/thumb/4/49/Tierno_Raichu.png/250px-Tierno_Raichu.png", R.raw.raichu, raichuStats));

        final PokemonListAdapter adapter = new PokemonListAdapter(getActivity(), R.layout.pokemon_list_item,
                pokemonList);
        pokemonListView.setAdapter(adapter);

        pokemonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Pokemon selectedPokemon = adapter.getItem(position);

                if (selectedPokemon != null) {
                    mListener.onPokemonSelected(selectedPokemon);
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onPokemonSelected(Pokemon pokemon);
    }
}
