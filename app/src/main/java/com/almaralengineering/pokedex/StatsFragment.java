package com.almaralengineering.pokedex;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class StatsFragment extends Fragment {

    public StatsFragment() {
        // Required empty public constructor
    }

    public static StatsFragment newInstance(Stats pokemonStats) {
        StatsFragment fragment = new StatsFragment();
        Bundle args = new Bundle();
        args.putParcelable("STATS", pokemonStats);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        TextView hpView = (TextView) view.findViewById(R.id.field_HP);
        TextView attackView = (TextView) view.findViewById(R.id.field_attack);
        TextView speedView = (TextView) view.findViewById(R.id.field_Speed);
        TextView defenseView = (TextView) view.findViewById(R.id.field_defense);

        if(getArguments() != null){
            Stats pokemonStats = getArguments().getParcelable("STATS");
            hpView.setText(pokemonStats.getHp());
            attackView.setText(pokemonStats.getAttack());
            speedView.setText(pokemonStats.getSpeed());
            defenseView.setText(pokemonStats.getDefense());
        }

        return view;
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }

}
