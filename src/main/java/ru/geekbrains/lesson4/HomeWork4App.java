package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 23.08.2021
 */
public class HomeWork4App {

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static char playerPoint = '@';
    public static String playerName = "Boris";
    public static int playerHealthPoint = 100;
    public static int playerAttackPoint = 15;
    public static int playerPositionX;
    public static int playerPositionY;
    public static final int PLAYER_MOVE_UP = 8;
    public static final int PLAYER_MOVE_DOWN = 2;
    public static final int PLAYER_MOVE_LEFT = 4;
    public static final int PLAYER_MOVE_RIGHT = 6;

    public static char enemyPoint = 'E';
    public static int enemyHealthPoint;
    public static int enemyAttackPoint;
    public static int enemyValueMin = 20;
    public static int enemyValueMax = 30;

    public static char[][] map;
    public static char[][] invisibleMap;
    public static int mapWidth;
    public static int mapHeight;
    public static int mapValueMin = 3;
    public static int mapValueMax = 6;
    public static char mapEmpty = '_';
    public static char mapReady = '*';
    public static int levelCount = 0;


    public static void main(String[] args) {

        while (isPlayerAlive()) {
            ++levelCount;
            System.out.println("===== START LEVEL " + levelCount + " =====");
            levelCycle();
        }
        System.out.println("===== GAME OVER! " + playerName + " ready " + levelCount + " levels =====");
    }

    public static void levelCycle() {
        createMap();
        spawnPlayer();
        spawnEnemy();

        while(true) {
            showMap();
            changePositionPlayer();

            if (!isPlayerAlive()) {
                System.out.println(playerName + " is dead!");
                break;
            }

            if (isFullMap()) {
                System.out.println("Map is Full! " + playerName + " win this Level");
                break;
            }
        }
    }

    public static void createMap() {
        mapHeight = randomValue(mapValueMin, mapValueMax);
        mapWidth = randomValue(mapValueMin, mapValueMax);
        map = new char[mapHeight][mapWidth];
        invisibleMap = new char[mapHeight][mapWidth];

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                map[y][x] = mapEmpty;
            }
        }
        System.out.println("Create map. Size " + mapWidth + "x" + mapHeight);

    }

    public static void showMap() {
        System.out.println("===== MAP =====");
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("===============");
    }

    public static void spawnPlayer() {
        playerPositionX = randomValue(0, mapWidth - 1);
        playerPositionY = randomValue(0, mapHeight - 1);
        map[playerPositionY][playerPositionX] = playerPoint;
        System.out.println(playerName + " has spawn in [" + (playerPositionX + 1) + ":" + (playerPositionY + 1) + "]. Health point " + playerHealthPoint);
    }

    public static void spawnEnemy() {
        enemyAttackPoint = randomValue(enemyValueMin, enemyValueMax);
        enemyHealthPoint = randomValue(enemyValueMin, enemyValueMax);

        int countEnemies = (mapWidth + mapHeight) / 4; // random math logic

        int enemyPosX;
        int enemyPosY;

        for (int i = 0; i < countEnemies; i++) {

            do {
                enemyPosX = random.nextInt(mapWidth);
                enemyPosY = random.nextInt(mapHeight);
            } while (enemyPosX == playerPositionX && enemyPosY == playerPositionY);

            invisibleMap[enemyPosY][enemyPosX] = enemyPoint;
        }

        System.out.println("Create enemy. Count = " + countEnemies + " (Health " + enemyHealthPoint + ", Attack " + enemyAttackPoint + ")");
    }

    public static void changePositionPlayer() {
        int currentX = playerPositionX;
        int currentY = playerPositionY;

        int playerMove;

        do {
            System.out.print("Please, enter your move (UP = " + PLAYER_MOVE_UP +
                    ", LEFT = " + PLAYER_MOVE_LEFT +
                    ", RIGTH = " + PLAYER_MOVE_RIGHT +
                    ", DOWN = " + PLAYER_MOVE_DOWN + ") >>> ");

            playerMove = scanner.nextInt();

            switch (playerMove) {
                case PLAYER_MOVE_UP:
                    playerPositionY -= 1;
                    break;
                case PLAYER_MOVE_LEFT:
                    playerPositionX -= 1;
                    break;
                case PLAYER_MOVE_RIGHT:
                    playerPositionX += 1;
                    break;
                case PLAYER_MOVE_DOWN:
                    playerPositionY += 1;
                    break;
                default:
                    System.out.println(playerName + " is Invalid! Your move is fail!");
                    continue;
            }
        } while (!isValidPlayerStep(currentX, currentY, playerPositionX, playerPositionY));

        playerNextMoveAction(currentX, currentY, playerPositionX, playerPositionY);
    }

    public static void playerNextMoveAction(int currentX, int currentY, int nextX, int nextY) {
        if (invisibleMap[nextY][nextX] == enemyPoint) {
            playerHealthPoint -= enemyAttackPoint;
            System.out.println("WARNING! Enemy give damage " + enemyAttackPoint + ". " + playerName + " health now " + playerHealthPoint);
        }

        invisibleMap[nextY][nextX] = mapEmpty;
        map[currentY][currentX] = mapReady;
        map[nextY][nextX] = playerPoint;
    }

    public static boolean isValidPlayerStep(int currentX, int currentY, int nextX, int nextY) {
//        if (nextX >= 0 && nextX < mapWidth && nextY >= 0 && currentY < mapHeight) {
//        if (nextX >= 0 && currentX < mapWidth && nextY >= 0 && currentY < mapHeight) {
        if (nextX >= 0 && nextX < mapWidth && nextY >= 0 && nextY < mapHeight) {

            System.out.println(playerName + " move to [" + (nextX + 1) + ":" + (nextY + 1) + "] success!");
            return true;
        } else {
            playerPositionX = currentX;
            playerPositionY = currentY;
            System.out.println(playerName + " is Invalid! Your move is fail!");
            return false;
        }
    }

    public static boolean isFullMap() {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                if (map[y][x] == mapEmpty) return false;
            }
        }
        return true;
    }

    public static int randomValue(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static boolean isPlayerAlive() {
        return playerHealthPoint > 0;
    }
}

