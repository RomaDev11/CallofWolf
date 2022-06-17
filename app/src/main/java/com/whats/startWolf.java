package com.whats;

import android.app.AlertDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class startWolf extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start_wolf2, container, false);
        NavController dsffsdfds = NavHostFragment.findNavController(startWolf.this);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button start = view.findViewById(R.id.start);
        Button startRules = view.findViewById(R.id.startRules);
        Button startExit = view.findViewById(R.id.startExit);
        startExit.setOnClickListener(view1 -> {
            AlertDialog.Builder ex = new AlertDialog.Builder(getContext());
            ex.setTitle("Do you want to exit the application?");
            ex.setCancelable(false);
            ex.setPositiveButton("Yes", (dialogInterface, i) -> {
                getActivity().finish();
                System.exit(0);
            });
            ex.setNegativeButton("No", (dialogInterface, i) -> dialogInterface.dismiss());
            ex.show();
        });
        start.setOnClickListener(view1 -> {
            dsffsdfds.navigate(R.id.action_startWolf2_to_gameWolf);
        });
        startRules.setOnClickListener(view1 -> {
            AlertDialog.Builder rulesss = new AlertDialog.Builder(getContext());
            rulesss.setTitle("How to play the game!");
            rulesss.setIcon(R.drawable.icon);
            rulesss.setMessage("You have to find 3 main riches" + "\n" + "To do this, you need to find 4 items from the scroll"
                    + "\n" + "You can also buy additional scrolls if you find 4 letters");
            rulesss.setCancelable(false);
            rulesss.setNegativeButton("OK", (dialogInterface, i) -> dialogInterface.dismiss());
            rulesss.show();
        });


        return view;
    }
}