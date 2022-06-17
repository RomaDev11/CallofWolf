package com.whats;

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
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;


public class gameWolf extends Fragment {
    HorizontalScrollView scroll_layoutWolf;
    Button startScrollWolf;
    ImageView BackWolf;
    TextView attemptWolf;
    ImageView imageViewTWolf;
    ImageView imageButtonInfoWolf;
    ImageView imageWinWolf;

    Handler hanWolf = new Handler();
    Random ranWolf = new Random();

    public static Boolean[] partOneWolf = new Boolean[]{false,false,false,false};
    public static Boolean[] partTwoWolf = new Boolean[]{false,false,false,false};

    public Boolean startOneWolf = true;
    public Boolean startAnimateWolf = true;
    public Boolean startTryAgainWolf = false;
    public static Boolean startFouWolf = true;

    private final int[] arrayStopWolf = new int[40];
    int Wolf = 0;
    public static int attWolf = 10;
    int stopWolf;
    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_wolf, container, false);
        NavController gameNWolf = NavHostFragment.findNavController(gameWolf.this);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        scroll_layoutWolf = view.findViewById(R.id.scroll_layout);
        imageViewTWolf = view.findViewById(R.id.imageViewT);
        attemptWolf = view.findViewById(R.id.attempt);
        startScrollWolf = view.findViewById(R.id.startScroll);
        imageButtonInfoWolf = view.findViewById(R.id.imageButtonInfo);
        BackWolf = view.findViewById(R.id.Back);
        imageWinWolf = view.findViewById(R.id.image1);
        int u = 0;
        for (int j = 0; j < arrayStopWolf.length; j++) {
            u += 55;
            arrayStopWolf[j] = u;
        }
        BackWolf.setOnClickListener(view1 -> gameNWolf.navigate(R.id.action_gameWolf_to_startWolf2));


        scroll_layoutWolf.setOnTouchListener((view12, motionEvent) -> true);
        imageButtonInfoWolf.setOnClickListener(view13 -> gameNWolf.navigate(R.id.action_gameWolf_to_gameWolf2));
        attemptWolf.setText(""+ attWolf);
        startScrollWolf.setOnClickListener(view1 -> {
            if(startTryAgainWolf){
                attWolf = 10;
                attemptWolf.setText(""+ attWolf);
                startScrollWolf.setText("Scroll");
                startTryAgainWolf = false;
            }
            startScrollWolf.setVisibility(View.INVISIBLE);
            if(attWolf > 0) {
                attWolf -= 1;
                ScrollRWolf();
                attemptWolf.setText(""+ attWolf);
            }else{
                startScrollWolf.setVisibility(View.VISIBLE);
                attemptWolf.setText("You lost");
                startScrollWolf.setText("try again");
                Arrays.fill(partOneWolf,false);
                Arrays.fill(partTwoWolf,false);
                startTryAgainWolf = true;
            }
        });

        return view;
    }

    private void ScrollRWolf() {
        startAnimateWolf = true;
        hanWolf.post(new Runnable() {
            @Override
            public void run() {
                if(startAnimateWolf) {
                    hanWolf.postDelayed(this, 150);
                    imageViewTWolf.animate().setDuration(60).rotationBy(-35).withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            imageViewTWolf.animate().setDuration(0).rotationBy(35);
                        }
                    });
                }else{
                    hanWolf.removeCallbacks(this);
                }
            }
        });
        Wolf = 0;
        startOneWolf = true;
        scroll_layoutWolf.scrollTo(0,0);
        int x = this.scroll_layoutWolf.getScrollX();
        int y = this.scroll_layoutWolf.getScrollY();
        if(startFouWolf) {
            if (partOneWolf[0] && partOneWolf[1] && partOneWolf[2] && partOneWolf[3]) {
                startFouWolf = false;
                Toast.makeText(getContext(), "You can buy more scrolls", Toast.LENGTH_SHORT).show();
                stopWolf = ranWolf.nextInt(arrayStopWolf.length);
            } else {
                if(!partOneWolf[3]){
                    stopWolf = 39;
                }else if(!partOneWolf[2]){
                    stopWolf = 28;
                }else if(!partOneWolf[1]){
                    stopWolf = 12;
                }else if(!partOneWolf[0]){
                    stopWolf = 1;
                }
            }
        }else {
            if(!partTwoWolf[3]){
                stopWolf = 34;
            }else if(!partTwoWolf[2]){
                stopWolf = 22;
            }else{
                stopWolf = ranWolf.nextInt(arrayStopWolf.length);
            }
        }
        hanWolf.post(new Runnable() {
            @Override
            public void run() {
                hanWolf.postDelayed(this, 30);
                if (startOneWolf) {
                    if (Wolf < 2200) {
                        Wolf += 55;
                        if (x + Wolf <= 2200) {
                            scroll_layoutWolf.scrollTo(x + Wolf, y);
                        }
                    } else {
                        startOneWolf = false;
                        Wolf = 0;
                    }
                } else {
                    if (Wolf < 2200) {
                        Wolf += 55;
                        if (Wolf == arrayStopWolf[stopWolf]) {
                            int x = scroll_layoutWolf.getScrollX();
                            if(x == 2200){
                                x = 0;
                            }
                            scroll_layoutWolf.scrollTo(x, y);
                            Wolf = 2200;
                            startAnimateWolf =false;
                            if(stopWolf <= 4){
                                partOneWolf[0] = true;
                                imageWinWolf.setBackgroundResource(R.drawable.im11);
                            }
                            if(stopWolf <= 9 && stopWolf >= 5){
                                partTwoWolf[0] = true;
                                imageWinWolf.setBackgroundResource(R.drawable.im22);
                            }
                            if(stopWolf <= 14 && stopWolf >= 10){
                                partOneWolf[1] = true;
                                imageWinWolf.setBackgroundResource(R.drawable.im13);
                            }
                            if(stopWolf <= 19 && stopWolf >= 15){
                                partTwoWolf[1] = true;
                                imageWinWolf.setBackgroundResource(R.drawable.im24);
                            }
                            if(stopWolf <= 25 && stopWolf >= 20){
                                partTwoWolf[2] = true;
                                imageWinWolf.setBackgroundResource(R.drawable.im21);
                            }
                            if(stopWolf <= 31 && stopWolf >= 26){
                                partOneWolf[2] = true;
                                imageWinWolf.setBackgroundResource(R.drawable.in12);
                            }
                            if(stopWolf <= 36 && stopWolf >= 32){
                                partTwoWolf[3] = true;
                                imageWinWolf.setBackgroundResource(R.drawable.im23);
                            }
                            if(stopWolf <= 40 && stopWolf >= 37){
                                partOneWolf[3] = true;
                                imageWinWolf.setBackgroundResource(R.drawable.im14);
                            }
                            startScrollWolf.setVisibility(View.VISIBLE);
                            hanWolf.removeCallbacks(this);
                        } else if (x + Wolf <= 2200) {
                            scroll_layoutWolf.scrollTo(x + Wolf, y);
                        }
                    }
                }
            }
        });
    }
}