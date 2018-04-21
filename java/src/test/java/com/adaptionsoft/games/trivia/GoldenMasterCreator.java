package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.TestableGameRunner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class GoldenMasterCreator {

    public static void main(String[] args) throws FileNotFoundException {

        for ( Integer $i = 0; $i <= 1000; $i++ ) {

            String seed = Integer.toString($i);
            String[] arguments = {seed};

            String filename = "/Users/blauss01/Workspace/kata/trivia/java/src/test/java/Masters/masterTest" + seed + ".txt";

            PrintStream out = new PrintStream(new FileOutputStream(filename));
            System.setOut(out);

            TestableGameRunner.main(arguments);

            System.out.flush();
        }
    }
}
