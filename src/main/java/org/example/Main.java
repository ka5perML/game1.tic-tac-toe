package org.example;

import java.util.Scanner;

public class Main {
    static int mapSize = 3;
    static char[][] map = new char[mapSize][mapSize];;
    static char defoult = '*';
    static char human = 'X';
    static char bot = 'O';
    static boolean state = false;
    public static void main(String[] args) {
        mapLoad();
        mapStart();
        while (!state) {
            gameHuman();
            mapStart();
            if(checkWins(human)){
                System.out.println("Победил человек");
                break;
            }
            if(checkMap()){
                System.out.println("Ничья");
                break;
            }
            gameBot();
            mapStart();
            if(checkWins(bot)){
                System.out.println("Победил бот");
                break;
            }
            if(checkMap()){
                System.out.println("Ничья");
                break;
            }
        }
    }
    public static void mapLoad(){
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++) {
                map[i][j] = defoult;
            }
        }
    }
    public static void mapStart(){
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
    public static void gameHuman(){
        Scanner sc = new Scanner(System.in);
        int x,y;
        do {
            System.out.println("Введите координаты");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        }while (!isValid(x,y));
            map[x][y] = human;
    }
    public static void gameBot(){
        int x,y;
        do {
            x = (int) (Math.random() * mapSize);
            y = (int) (Math.random() * mapSize);
        }while (!isValid(x,y));
        System.out.println("Ходит бот");
        map[x][y] = bot;
    }
    public static boolean isValid(int x, int y){
        if(x < 0 || y < 0 || x > mapSize|| y > mapSize){
            return false;
        }
        if(map[x][y] != defoult){
            return false;
        }
        return true;
    }
    public static boolean checkMap(){
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++) {
                if (map[i][j] == defoult){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkWins(char move){
        if(map[0][0] == move && map[0][1] == move && map[0][2] == move) return true;
        if(map[1][0] == move && map[1][1] == move && map[1][2] == move) return true;
        if(map[2][0] == move && map[2][1] == move && map[2][2] == move) return true;
        if(map[0][0] == move && map[1][0] == move && map[2][0] == move) return true;
        if(map[0][1] == move && map[1][1] == move && map[2][1] == move) return true;
        if(map[0][2] == move && map[1][2] == move && map[2][2] == move) return true;
        if(map[0][0] == move && map[1][1] == move && map[2][2] == move) return true;
        if(map[0][2] == move && map[1][1] == move && map[2][0] == move) return true;
        return false;
    }
}