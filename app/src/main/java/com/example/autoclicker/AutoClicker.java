package com.example.autoclicker;

import android.os.AsyncTask;

public class AutoClicker extends AsyncTask<Void, Void, Void> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        String command = String.format("input tap %s %s", MainActivity.pointX, MainActivity.pointY);
        while (!MainActivity.stopFlag){
            ExecuteCommand.initializeSu();
            ExecuteCommand.execCommand(command);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }


}
