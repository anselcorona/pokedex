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

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(new Pokemon("1", "Bulbasaur", Pokemon.Type.PLANT, R.drawable.bulbasaur));
        pokemonList.add(new Pokemon("2", "Ivysaur", Pokemon.Type.PLANT,R.drawable.ivysaur));
        pokemonList.add(new Pokemon("3", "Venuasaur", Pokemon.Type.PLANT,R.drawable.venusaur));
        pokemonList.add(new Pokemon("4", "Charmander", Pokemon.Type.FIRE,R.drawable.charmander));
        pokemonList.add(new Pokemon("5", "Charmeleon", Pokemon.Type.FIRE,R.drawable.charmeleon));
        pokemonList.add(new Pokemon("6", "Charizard", Pokemon.Type.FIRE,R.drawable.charizard));
        pokemonList.add(new Pokemon("7", "Squirtle", Pokemon.Type.WATER,R.drawable.squirtle));
        pokemonList.add(new Pokemon("8", "Wartortle", Pokemon.Type.WATER,R.drawable.wartortle));
        pokemonList.add(new Pokemon("9", "Blastoise", Pokemon.Type.WATER,R.drawable.blastoise));
        pokemonList.add(new Pokemon("25", "Pikachu", Pokemon.Type.ELECTRIC,R.drawable.pikachu));
        pokemonList.add(new Pokemon("26", "Raichu", Pokemon.Type.ELECTRIC,R.drawable.raichu));

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
