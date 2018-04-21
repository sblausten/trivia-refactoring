package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.TestableGameRunner;
import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GolderMasterTest {

    public static final String BASE_PATH = "/Users/blauss01/Workspace/kata/trivia/java/src/test/java/Masters" +
            "/masterTest";

    @Test
    public void check_golden_master() throws Exception {

        for (Integer $i = 0; $i <= 1000; $i++) {
            // Setup
            String seed = Integer.toString($i);
            String[] args = {seed};

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream actualPS = new PrintStream(baos);
            System.setOut(actualPS);

            // When
            TestableGameRunner.main(args);

            // Capture output
            String actual = new String(baos.toByteArray(), StandardCharsets.UTF_8);

            // Clean up
            actualPS.close();
            baos.close();
            System.out.flush();

            // Get expected result
            String path = BASE_PATH + seed + ".txt";
            Path expectedFilePath = Paths.get(path);

            boolean fileExists = new File(path).exists();
            System.out.println(fileExists);

            String expected = new String(Files.readAllBytes(expectedFilePath), StandardCharsets.UTF_8);

            assertThat(actual, is(expected));
        }
    }

    @Test(expected = Exception.class)
    public void can_not_play_if_no_players() throws Exception {
        Game game = new Game();
        game.roll(1);
    }

    @Test(expected = Exception.class)
    public void can_not_play_with_one_player() throws Exception {
        Game game = new Game();
        game.add("Jane Doe");
        game.roll(1);
    }
}
