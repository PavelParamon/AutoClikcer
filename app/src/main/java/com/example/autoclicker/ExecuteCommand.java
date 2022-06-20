package com.example.autoclicker;

import java.io.DataOutputStream;
import java.io.IOException;

public class ExecuteCommand {
    private static Process suProcess;
    private static DataOutputStream os;

    static void initializeSu() {
        Runtime rt = Runtime.getRuntime();
        try {
            suProcess = rt.exec("su");
        } catch (IOException e) {
            e.printStackTrace();
        }
        os = new DataOutputStream(suProcess.getOutputStream());
    }

    static void execCommand(String command) {
        try {
            os.writeBytes(command + "\n");
            os.flush();
            os.writeBytes("exit\n");
            os.flush();
            try {
                suProcess.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
