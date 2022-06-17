package com.whats;

import static com.whats.gameWolf.attWolf;
import static com.whats.gameWolf.partOneWolf;
import static com.whats.gameWolf.partTwoWolf;
import static com.whats.gameWolf.startFouWolf;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;


public class gameWolf2 extends Fragment {
    ImageView[] imArvWolf = new ImageView[6];
    ImageView[] gdshfuWolf = new ImageView[4];
    ImageView[] imPartTwoWolf = new ImageView[4];
    int[] imageIdWolf;
    int[] imagePartOneWolf;
    int[] imagePartTwoWolf;
    int[] dravbArWolf = new int[]{R.drawable.im21, R.drawable.im22, R.drawable.im23, R.drawable.im31, R.drawable.icon, R.drawable.launcher};
    Button nextlevelWolf;
    Button plusattemptsWolf;
    ImageView BackGameWolf;
    Button playagainWolf;
    TextView textSprobaWolf;

    int pointWinWolf = 0;
    int sprobaWolf = 4;
    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_wolf2, container, false);
        NavController infoNav = NavHostFragment.findNavController(gameWolf2.this);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        imageIdWolf = new int[]{R.id.imageView1_1, R.id.imageView1_2, R.id.imageView1_3, R.id.imageView2_1, R.id.imageView2_2, R.id.imageView2_3};
        imagePartOneWolf = new int[]{R.id.imageView, R.id.imageView2, R.id.imageView3, R.id.imageView4};
        imagePartTwoWolf = new int[]{R.id.imageView21, R.id.imageView22, R.id.imageView23, R.id.imageView24};
        nextlevelWolf = view.findViewById(R.id.nextlevel);
        plusattemptsWolf = view.findViewById(R.id.plusattempts);
        BackGameWolf = view.findViewById(R.id.BackGame);
        textSprobaWolf = view.findViewById(R.id.textSproba);
        playagainWolf = view.findViewById(R.id.playagain);
        LinearLayout lnnn = view.findViewById(R.id.lnnn);
        shufWolf(dravbArWolf);
        textSprobaWolf.setText("" + sprobaWolf);
        for (int j = 0; j < imArvWolf.length; j++) {
            imArvWolf[j] = view.findViewById(imageIdWolf[j]);
        }
        for (int i = 0; i < gdshfuWolf.length; i++) {
            gdshfuWolf[i] = view.findViewById(imagePartOneWolf[i]);
            imPartTwoWolf[i] = view.findViewById(imagePartTwoWolf[i]);
            if (partOneWolf[i]) {
                gdshfuWolf[i].setBackgroundColor(R.color.purple_500);
            }
            if (partTwoWolf[i]) {
                imPartTwoWolf[i].setBackgroundColor(R.color.purple_500);
            }
        }
        BackGameWolf.setOnClickListener(view1 -> {
            infoNav.navigate(R.id.action_gameWolf2_to_gameWolf);
        });
        playagainWolf.setOnClickListener(view1 -> {
            startFouWolf = false;
            infoNav.navigate(R.id.action_gameWolf2_to_gameWolf);
        });
        plusattemptsWolf.setOnClickListener(view1 -> {
            if (partOneWolf[0] && partOneWolf[1] && partOneWolf[2] && partOneWolf[3]) {
                startFouWolf = false;
                attWolf += 10;
                Arrays.fill(partOneWolf, false);
            } else {
                Toast.makeText(getContext(), "you didn't knock out all the items", Toast.LENGTH_SHORT).show();
            }
        });
        nextlevelWolf.setOnClickListener(view1 -> {
            if (partTwoWolf[0] && partTwoWolf[1] && partTwoWolf[2] && partTwoWolf[3]) {
                textSprobaWolf.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), "you didn't knock out all the items", Toast.LENGTH_SHORT).show();
                lnnn.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(getContext(), "you didn't knock out all the items", Toast.LENGTH_SHORT).show();
            }
        });
        int[] arrayWin = new int[]{R.drawable.im31, R.drawable.icon, R.drawable.launcher};
        for (int i = 0; i < imArvWolf.length; i++) {
            int finalI = i;
            imArvWolf[i].setOnClickListener(view1 -> {
                if (sprobaWolf > 0) {
                    sprobaWolf--;
                    textSprobaWolf.setText("" + sprobaWolf);
                    imArvWolf[finalI].setImageResource(dravbArWolf[finalI]);
                    for (int j = 0; j < arrayWin.length; j++) {
                        if (dravbArWolf[finalI] == arrayWin[j]) {
                            pointWinWolf++;

                            if (pointWinWolf == 3) {
                                Toast.makeText(getContext(), "You won, you can play again", Toast.LENGTH_SHORT).show();
                                new Handler().postDelayed(() -> {
                                    playagainWolf.setVisibility(View.VISIBLE);
                                    attWolf = 10;
                                    Arrays.fill(partOneWolf, false);
                                    Arrays.fill(partTwoWolf, false);
                                }, 1000);
                            }
                        }
                    }
                    if (dravbArWolf[finalI] == R.drawable.im21 || dravbArWolf[finalI] == R.drawable.im22
                            || dravbArWolf[finalI] == R.drawable.im23) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imArvWolf[finalI].setImageResource(R.drawable.diamant);
                            }
                        }, 1000);
                    }
                } else {
                    textSprobaWolf.setVisibility(View.INVISIBLE);
                    playagainWolf.setVisibility(View.VISIBLE);
                    Toast.makeText(getContext(), "you lost try again", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            attWolf = 10;
                            Arrays.fill(partOneWolf, false);
                            Arrays.fill(partTwoWolf, false);
                            infoNav.navigate(R.id.action_gameWolf2_to_gameWolf);
                        }
                    }, 1000);
                }
            });
        }

        return view;
    }

    private void shufWolf(int[] dravbAr) {
        Random n = new Random();
        for (int j = 0; j < dravbAr.length; j++) {
            int poin = n.nextInt(j + 1);
            int m = dravbAr[poin];
            dravbAr[poin] = dravbAr[j];
            dravbAr[j] = m;
        }
    }
}