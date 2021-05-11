package edu.bit.problemsolving.competitive.amazon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class RobotInstructions {

    public static List<String> doesCircleExist(List<String> commands) {
        List<String> commandResult = new ArrayList<>(commands.size());
        for (String command : commands) {
            if (circleExists(String.join("", Collections.nCopies(4, command)).toCharArray())) {
                commandResult.add("YES");
            } else {
                commandResult.add("NO");
            }
        }
        return commandResult;
    }

    public static boolean circleExists(char instructions[]) {
        int x = 0, y = 0;
        int direction = 0;
        for (char instruction : instructions) {
            if (instruction == 'R') {
                direction = (direction + 1) % 4;
            } else if (instruction == 'L') {
                direction = (4 + direction - 1) % 4;
            } else {
                if (direction == 0) {
                    y++;
                } else if (direction == 1) {
                    x++;
                } else if (direction == 2) {
                    y--;
                } else {
                    x--;
                }
            }
        }
        return (x == 0 && y == 0); // back to the same coordinate
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int commandsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> commands = IntStream.range(0, commandsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = RobotInstructions.doesCircleExist(commands);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}