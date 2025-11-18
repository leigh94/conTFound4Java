package com.leigh4java.contfound4java.designMode.mementoPattern.example.advanced;

import java.util.HashMap;
import java.util.Map;

// 存档管理器
public class SaveManager {
    private Map<String, GameSaveMemento> saveFiles;
    private String currentSaveSlot;

    public SaveManager() {
        this.saveFiles = new HashMap<>();
        this.currentSaveSlot = "default";
    }

    // 保存游戏
    public void saveGame(GameCharacter character, String saveName) {
        GameSaveMemento save = character.saveGame(saveName);
        saveFiles.put(saveName, save);
        currentSaveSlot = saveName;
        System.out.println("游戏已保存到槽位: " + saveName);
    }

    // 加载游戏
    public void loadGame(GameCharacter character, String saveName) {
        GameSaveMemento save = saveFiles.get(saveName);
        if (save != null) {
            character.loadGame(save);
            currentSaveSlot = saveName;
        } else {
            System.out.println("存档不存在: " + saveName);
        }
    }

    // 删除存档
    public void deleteSave(String saveName) {
        if (saveFiles.remove(saveName) != null) {
            System.out.println("存档已删除: " + saveName);
        } else {
            System.out.println("存档不存在: " + saveName);
        }
    }

    // 列出所有存档
    public void listSaves() {
        System.out.println("=== 存档列表 ===");
        if (saveFiles.isEmpty()) {
            System.out.println("没有存档");
            return;
        }

        for (GameSaveMemento save : saveFiles.values()) {
            System.out.println("- " + save);
        }
    }

    // 自动保存
    public void autoSave(GameCharacter character) {
        String autoSaveName = "autosave_" + System.currentTimeMillis();
        saveGame(character, autoSaveName);
    }

    public String getCurrentSaveSlot() {
        return currentSaveSlot;
    }

    public int getSaveCount() {
        return saveFiles.size();
    }
}