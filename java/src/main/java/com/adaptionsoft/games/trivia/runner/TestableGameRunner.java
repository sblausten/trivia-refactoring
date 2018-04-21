
package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;

import java.util.Random;

import static java.lang.Integer.parseInt;


public class TestableGameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
	    int seed = parseInt(args[0]);
		Game aGame = new Game();
		
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");

        Random rand = new Random(seed);

        try {
            do {

                aGame.roll(rand.nextInt(5) + 1);

                if (rand.nextInt(9) == 7) {
                    notAWinner = aGame.wrongAnswer();
                } else {
                    notAWinner = aGame.wasCorrectlyAnswered();
                }



            } while (notAWinner);
        } catch (Exception e) {
            System.out.println("Cannot play");
        }
		
	}
}
