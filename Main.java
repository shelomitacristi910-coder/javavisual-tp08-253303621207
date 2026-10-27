package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        // Tiga karakter awal
        manager.addCharacter(new Character(
                1, "Arjuna", CharacterType.WARRIOR, 5, 150, 25));

        manager.addCharacter(new Character(
                2, "Merlin", CharacterType.MAGE, 3, 130, 20));

        manager.addCharacter(new Character(
                3, "Athena", CharacterType.ARCHER, 4, 140, 22));

        // Dua karakter baru untuk TP8
        manager.addCharacter(new Character(
                4, "Luna", CharacterType.HEALER, 6, 160, 15));

        manager.addCharacter(new Character(
                5, "Bima", CharacterType.WARRIOR, 8, 180, 30));

        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}