package com.cqupt.text.book;
import java.io.*;

/**
 * @author weigs
 * @date 2017/5/22 0022
 */
public class p444 {

    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf",
                new String[]{"bow","sword","dust"});
        GameCharacter two = new GameCharacter(200,"Troll",
                new String[]{"bare hands","big ax"});
        GameCharacter three = new GameCharacter(120,"Magician",
                new String[]{"spells","invisibility"});


        try {
            ObjectOutputStream os =
                    new ObjectOutputStream(new FileOutputStream("f:/Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream is =
                    new ObjectInputStream(new FileInputStream("f:/Game.ser"));
            GameCharacter oneRes = (GameCharacter) is.readObject();
            GameCharacter twoRes= (GameCharacter) is.readObject();
            GameCharacter threeRes = (GameCharacter) is.readObject();

            System.out.println("One's type "+oneRes.getType());
            System.out.println("Two's type "+twoRes.getType());
            System.out.println("Three's type "+threeRes.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

class GameCharacter implements Serializable{
    private int power;
    private String type;
    private String[] weapons;

    public GameCharacter(int power, String type, String[] weapons) {
        this.power = power;
        this.weapons = weapons;
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeapons() {
        String weaponList = "";

        for (int i = 0; i < weapons.length; i++) {
            weaponList += weapons[i]+" ";
        }
        return weaponList;
    }

}