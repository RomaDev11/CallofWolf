package com.whats.webWolf;
import static com.whats.webWolf.StartWolf.startGameWolf;
import static com.whats.webWolf.StartWolf.startWebWolf;
import static com.whats.webWolf.StringMethods.codWolf;
import static com.whats.webWolf.VariablsWolf.*;
import android.os.CountDownTimer;
import android.util.Log;

public class TimerWolf extends CountDownTimer {


    public TimerWolf(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        super.start();
    }

    @Override
    public void onTick(long l) {
        if(DATA_FROM_GIST_WOLF != null && !ST_APPS_WOLF.equals("")){
            DATA_FROM_GIST_WOLF[0] = "false";
            if (DATA_FROM_GIST_WOLF[0].equals("true")) {
                if (DEV_WOLF == 0) {
                    startWebWolf();
                    Log.i("MyLog", "Status = True, Dev = 0, FB/NAming = false/true");
                    super.cancel();
                } else {
                    if (!ST_APPS_WOLF.equals(codWolf("Qticpke", 2)) || !MAPS_APPS_WOLF[3].equals("")) {
                        startWebWolf();
                        Log.i("MyLog", "Status = True, Dev = 1, FB/NAming = true");
                        super.cancel();
                    } else {
                        startGameWolf();
                        Log.i("MyLog", "Status = True, Dev = 1, FB/NAming = false");
                        super.cancel();
                    }
                }

            } else {
                if (!ST_APPS_WOLF.equals("") && !MAPS_APPS_WOLF[3].equals("")) {
                    startWebWolf();
                    Log.i("MyLog", "Status = false, Dev = non, FB/NAming = true");
                    super.cancel();
                }
            }
        }
    }

    @Override
    public void onFinish() {
        startGameWolf();
    }
}
