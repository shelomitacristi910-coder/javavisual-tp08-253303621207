package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private ArrayList<Character> characters;

    public CharacterManager() {
        characters = new ArrayList<>();
    }

    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        if (characters.contains(character)) {
            return false;
        }

        characters.add(character);
        return true;
    }

    public Character findByName(String name) {
        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }

        return null;
    }

    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }
}