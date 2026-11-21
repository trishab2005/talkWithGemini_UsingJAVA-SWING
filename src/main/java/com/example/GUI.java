//package com.example;
//
//import java.awt.event.*;
//import javax.swing.*;
//
//public class GUI {
//
//    static void main() {
//
//        JFrame f=new JFrame("Gemini AI");
//        final JTextField tf=new JTextField();
//        tf.setBounds(50,50, 150,20);
//        JButton b=new JButton("Click Here");
//        b.setBounds(50,100,95,30);
//        b.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                String q=JOptionPane.showInputDialog("enter question ","type here");
//                String response=Talk.askQuestion(q);
//                tf.setText(response);
//            }
//        });
//        f.add(b);f.add(tf);
//        f.setSize(400,400);
//        f.setLayout(null);
//        f.setVisible(true);
//    }
//}


package com.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.concurrent.ExecutionException;

public class GUI {

    public static void main(String[] args) {
        // Use the native OS look and feel (macOS/Windows)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(GUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Gemini AI Assistant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 500);
        frame.setMinimumSize(new Dimension(450, 350));
        frame.setLocationRelativeTo(null); // Center on screen

        // Main container with padding
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // Scrollable output area with word wrapping
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        chatArea.setMargin(new Insets(10, 10, 10, 10));
        chatArea.setText("Welcome! Type a question below and press Enter or click Ask.\n\n");

        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Bottom input panel
        JPanel inputPanel = new JPanel(new BorderLayout(8, 0));
        JTextField questionField = new JTextField();
        questionField.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JButton askButton = new JButton("Ask Gemini");
        askButton.setFont(new Font("SansSerif", Font.BOLD, 13));
        askButton.setPreferredSize(new Dimension(120, 36));

        inputPanel.add(questionField, BorderLayout.CENTER);
        inputPanel.add(askButton, BorderLayout.EAST);

        // Status label at the top
        JLabel statusLabel = new JLabel("Ready");
        statusLabel.setForeground(Color.GRAY);
        statusLabel.setFont(new Font("SansSerif", Font.ITALIC, 12));

        mainPanel.add(statusLabel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // Action handler for both button click and Enter key
        Runnable submitQuestion = () -> {
            String question = questionField.getText().trim();
            if (question.isEmpty()) {
                return;
            }

            // Append user's question and lock controls during API call
            chatArea.append("You: " + question + "\n\n");
            questionField.setText("");
            questionField.setEnabled(false);
            askButton.setEnabled(false);
            statusLabel.setText("Gemini is thinking...");

            // Run API call on a background thread so the UI stays responsive
            new SwingWorker<String, Void>() {
                @Override
                protected String doInBackground() {
                    return Talk.askQuestion(question);
                }

                @Override
                protected void done() {
                    try {
                        String response = get();
                        chatArea.append("Gemini:\n" + response + "\n");
                        chatArea.append("--------------------------------------------------\n\n");
                    } catch (InterruptedException | ExecutionException ex) {
                        chatArea.append("Error: " + ex.getCause().getMessage() + "\n\n");
                    } finally {
                        // Auto-scroll to bottom and re-enable input
                        chatArea.setCaretPosition(chatArea.getDocument().getLength());
                        questionField.setEnabled(true);
                        askButton.setEnabled(true);
                        statusLabel.setText("Ready");
                        questionField.requestFocusInWindow();
                    }
                }
            }.execute();
        };

        askButton.addActionListener(e -> submitQuestion.run());
        questionField.addActionListener(e -> submitQuestion.run()); // Allows pressing Enter

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
        questionField.requestFocusInWindow();
    }
}