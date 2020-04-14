package ru.geekbrains.java2.client.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Log {
    private final String LOG_FILE_NAME  = "NetworkClient/history_%s.txt";
    private final int HOW_MUCH_LAST_MESSAGE_READ = 100;

    public void writeMessageToLog(String login, String message ) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getFileName(login), true))) {
            bufferedWriter.write(message + System.lineSeparator());
            bufferedWriter.flush();
        }  catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<String> readMessageFromLog(String login) {
        List<String> messages = new ArrayList<>();
        File file = getFileName(login);

        if (file.exists()){
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(getFileName(login))))
            {
                // чтение построчно
                for (int i = 0; i < HOW_MUCH_LAST_MESSAGE_READ; i++) {
    //            while((lineMessage = bufferedReader.readLine())!= null) {
                    String lineMessage = bufferedReader.readLine();
                    if(lineMessage != null){
                        messages.add(lineMessage);
                    } else {
                        break;
                    }
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        } else {
            try
            {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getFileName(login), true));
            }
            catch(IOException ex){
                ex.printStackTrace();
            }

        }
        return messages;
    }

    private File getFileName(String login) {
        return new File(String.format(LOG_FILE_NAME, login));
    }
}
