package com.pranavprksn.helibrary;

import android.util.Log;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FileOps {

    public boolean check(String F) {
        boolean res = false;
        File f = new File(F);
        res = f.exists();
        return res;
    }

    public void fileWrite(BigInteger[] temp, String FILENAME) {
        File f = null;
        boolean bool = false;
//        try {
//            f = new File(FILENAME);
//
//            bool = f.createNewFile();
//
//            System.out.println("File created: " + bool);
//            PrintWriter writer = new PrintWriter(FILENAME, String.valueOf(StandardCharsets.UTF_8));
//            writer.write(temp[0].toString());
//            writer.write(Objects.requireNonNull(System.getProperty("line.separator")));
//            writer.write(temp[1].toString());
//            writer.write(Objects.requireNonNull(System.getProperty("line.separator")));
//            writer.write(temp[2].toString());
//            writer.write(Objects.requireNonNull(System.getProperty("line.separator")));
//            writer.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            f = new File(FILENAME);

            f.createNewFile();
            FileOutputStream fOut = new FileOutputStream(f);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);

            String data = temp[0].toString() + "\n" + temp[1].toString() + "\n" + temp[2].toString();

            myOutWriter.append(data);

            myOutWriter.close();

            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public BigInteger[] getKey(String FILENAME) {
        BufferedReader br = null;
        FileReader fr = null;
        String sCurrentLine = null;
        BigInteger[] temp = new BigInteger[3];

        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            br = new BufferedReader(new FileReader(FILENAME));
            int i = 0;

            while ((sCurrentLine = br.readLine()) != null) {
                temp[i] = new BigInteger(sCurrentLine);
                i++;
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        return temp;

    }
}