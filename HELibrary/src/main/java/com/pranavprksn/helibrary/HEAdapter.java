package com.pranavprksn.helibrary;

import android.util.Log;

public class HEAdapter {

    public static void HECall(String entered_text) {

        if (entered_text == null || entered_text.equals("")) {
            entered_text = "Dummy Text";
        }

        String encrypted = HED.encryptHE(entered_text);
        String decrypted = HED.decryptHE(encrypted);

        Log.d("ENA-OBJ:", encrypted);
        Log.d("DEC-OBJ:", decrypted);
    }

}
