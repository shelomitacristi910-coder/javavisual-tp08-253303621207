package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    private final CharacterManager characterManager;
    private final JPanel characterPanel;
    private final JLabel averageLevelLabel;

    public MainWindow(CharacterManager characterManager) {
        this.characterManager = characterManager;

        setTitle("Character Manager - TP8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        characterPanel = new JPanel();
        characterPanel.setLayout(
    new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
);

        averageLevelLabel = new JLabel();
        averageLevelLabel.setBorder(
                BorderFactory.createEmptyBorder(10, 5, 10, 5));

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15));

        mainPanel.add(
                new JLabel("Daftar Karakter"),
                BorderLayout.NORTH);

        mainPanel.add(
                characterPanel,
                BorderLayout.CENTER);

        mainPanel.add(
                averageLevelLabel,
                BorderLayout.SOUTH);

        add(mainPanel);

        refreshCharacters();
    }

    public void refreshCharacters() {
        characterPanel.removeAll();

        List<Character> characters = characterManager.getAllCharacters();

        for (Character character : characters) {
            JLabel characterLabel = new JLabel(
                    character.getName()
                            + " | Tipe: " + character.getType()
                            + " | Level: " + character.getLevel());

            characterLabel.setBorder(
                    BorderFactory.createEmptyBorder(5, 0, 5, 0));

            characterPanel.add(characterLabel);
        }

        averageLevelLabel.setText(
                String.format(
                        "Rata-rata Level: %.2f (%d karakter)",
                        characterManager.getAverageLevel(),
                        characters.size()));

        characterPanel.revalidate();
        characterPanel.repaint();
    }
}