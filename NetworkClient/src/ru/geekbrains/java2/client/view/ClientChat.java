package ru.geekbrains.java2.client.view;

import ru.geekbrains.java2.client.controller.ClientController;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ClientChat extends JFrame {

    private JPanel mainPanel;
    private JList<String> usersList;
    private JTextField messageTextField;
    private JButton sendButton;
    private JTextArea chatText;

    private ClientController controller;

    public ClientChat(ClientController controller) {
        this.controller = controller;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        addListeners();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                controller.shutdown();
            }
        });
    }


    private void addListeners() {
        sendButton.addActionListener(e -> ClientChat.this.sendMessage());
        messageTextField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String message = messageTextField.getText().trim();
        if (message.isEmpty()) {
            return;
        }

        appendOwnMessage(message);

        if (usersList.getSelectedIndex() < 1) {
            controller.sendMessageToAllUsers(message);
        }
        else {
            String username = usersList.getSelectedValue();
            controller.sendPrivateMessage(username, message);
        }

        messageTextField.setText(null);
    }

    public void appendMessage(String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                controller.getLog().writeMessageToLog(controller.getLogin(), message);
                chatText.append(message);
                chatText.append(System.lineSeparator());
            }
        });
    }

    public void addHistoryToChatText(List<String> list){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                while (!list.isEmpty()){
                    chatText.append(list.get(0));
                    chatText.append(System.lineSeparator());
                    list.remove(0);
                }
            }
        });
    }

    private void appendOwnMessage(String message) {
        appendMessage("Я: " + message);
    }


    public void showError(String message) {
        JOptionPane.showMessageDialog(this, "Failed to send message!");
    }

//    public void updateUsers(List<String> users) {
//        SwingUtilities.invokeLater(() -> {
//            //2:11:53
//            DefaultListModel<String> model = new DefaultListModel<>();
//            //model.addAll(users);
//            usersList.setModel(model);
//        });
//    }
}
