package tianchai;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/11/13.
 */
public class UFOTest {
    public static void main(String[] args) {
//        System.out.println((int) 'a' - 96);//1
        String ufoName = "ABSTAR";
        String teamName = "USACO";
        Scanner scanner = new Scanner(System.in);
        ufoName = scanner.nextLine();
        teamName = scanner.nextLine();
        if (goOrStay(ufoName, teamName)) {
            System.out.println("GO");
        } else {
            System.out.println("STAY");
        }
    }

    private static boolean goOrStay(String ufoName, String teamName) {
        ufoName = ufoName.trim().toLowerCase();
        teamName = teamName.trim().toLowerCase();
        if (ufoName == null || ufoName.length() > 6) {
            throw new RuntimeException("ufoName is cannot parse!");
        }
        if (teamName == null || teamName.length() > 6) {
            throw new RuntimeException("teamName is cannot parse!");
        }
        char[] ufoNameChars = ufoName.toCharArray();
        char[] teamNameChars = teamName.toCharArray();
        long ufoNameNumber = 1;
        for (char ufoNameChar : ufoNameChars) {
            ufoNameNumber *= ufoNameChar - 96;
        }
        long teamNameNumber = 1;
        for (char teamNameChar : teamNameChars) {
            teamNameNumber *= teamNameChar - 96;
        }
        return (ufoNameNumber % 47) == (teamNameNumber % 47);
    }
}
