package HW_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HW_J_5 {

    static int countLines(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int count = 0;
            while (bufferedReader.readLine() != null) {
                count++;
            }
            return count;
        }
    }

    static int countElements(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return 0;
            }
            return line.split(" ").length;
        }
    }

    static int[][] downLoadMap(String path) throws IOException {

        int[][] map = new int[countLines(path)][countElements(path)];

        FileReader fileReader = new FileReader(path);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String currentLine;
            int line = 0;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] arrayLine = currentLine.split(" ");

                for (int i = 0; i < arrayLine.length; i++) {
                    map[line][i] = Integer.parseInt(arrayLine[i]);
                }
                line++;
            }
        }

        return map;
    }

    static void exploreMap(int[][] map, int x, int y, int count) {
        if (map[y - 1][x] != -1 && (map[y - 1][x] >= count || map[y - 1][x] == -2)) {
            map[y - 1][x] = count;
            exploreMap(map, x, y - 1, count + 1);
        }
        if (map[y][x + 1] != -1 && (map[y][x + 1] >= count || map[y][x + 1] == -2)) {
            map[y][x + 1] = count;
            exploreMap(map, x + 1, y, count + 1);
        }
        if (map[y + 1][x] != -1 && (map[y + 1][x] >= count || map[y + 1][x] == -2)) {
            map[y + 1][x] = count;
            exploreMap(map, x, y + 1, count + 1);
        }
        if (map[y][x - 1] != -1 && (map[y][x - 1] >= count || map[y][x - 1] == -2)) {
            map[y][x - 1] = count;
            exploreMap(map, x - 1, y, count + 1);
        }
    }

    static void printMap(int[][] map) {
        for (int[] y : map) {
            for (int x : y) {
                switch (x) {
                    case -1:
                        System.out.print("#|");
                        break;
                    case -2:
                        System.out.print(" |");
                        break;
                    default:
                        System.out.print(x + "|");
                        break;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "HW_5/map.txt";
        int[][] map = downLoadMap(path);

        printMap(map);

        try (Scanner iScanner = new Scanner(System.in)) {
            Integer spawnX = 0;
            Integer spawnY = 0;

            while (map[spawnY][spawnX] == -1) {
                System.out.print("Введите X: ");
                spawnX = iScanner.nextInt();

                System.out.print("Введите Y: ");
                spawnY = iScanner.nextInt();

                if (spawnX > 0 && spawnY > 0 && spawnX < countElements(path) && spawnY < countLines(path)){
                    if (map[spawnY][spawnX] == -1) {
                        System.out.println("Ошибка! Координата находится в стене");
                        spawnX = 0;
                        spawnY = 0;
                    }
                }
                else {
                        System.out.println("Ошибка! Координата находится за пределами карты");
                        spawnX = 0;
                        spawnY = 0;
                    }
            }
            map[spawnY][spawnX] = 0;
            exploreMap(map, spawnX, spawnY, 1);
        }
        printMap(map);
    }
}