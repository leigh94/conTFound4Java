package com.leigh4java.contfound4java.designMode.mementoPattern.example.advanced;

import java.io.*;

// 游戏存档备忘录
public class GameSaveMemento implements Serializable {
    private final GameCharacterState characterState;
    private final long saveTime;
    private final String saveName;

    public GameSaveMemento(GameCharacterState characterState, String saveName) {
        this.characterState = deepCopy(characterState);
        this.saveTime = System.currentTimeMillis();
        this.saveName = saveName;
    }

    public GameCharacterState getCharacterState() {
        return deepCopy(characterState);
    }

    public long getSaveTime() {
        return saveTime;
    }

    public String getSaveName() {
        return saveName;
    }

    @Override
    public String toString() {
        return String.format("存档: %s [%s] - %s",
                saveName, new java.util.Date(saveTime), characterState);
    }

    // 深拷贝工具方法
    private GameCharacterState deepCopy(GameCharacterState original) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(original);
            oos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (GameCharacterState) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("深拷贝失败", e);
        }
    }
}
