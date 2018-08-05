package com.sofialopes.android.jokejavalib;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JavaJoker {
    public String jokeProvider() {
        List<String> jokesList = Arrays.asList(
                "Why was King Arthur's army too tired to fight?\n" +
                        "\n" +
                        "It had too many sleepless knights.",

                "If anyone needs an ark, I happen to Noah guy.",

                "Two fish are in a tank. One says to the other:\n" +
                        "\n" +
                        "Do you know how to drive this thing?",

                "How many cats can you put in an empty box?\n" +
                        "\n" +
                        "One. After that, the box isn't empty anymore.",

                "The shovel was a ground-breaking invention.",

                "Why don't skeletons ever go trick or treating?\n" +
                        "\n" +
                        "Because they have no body to go with.",

                "How many apples grow on a tree?\n" +
                        "\n" +
                        "All of them.",

                "What do you get if you cross an angry sheep and a moody cow?\n" +
                        "\n" +
                        "An animal that's in a baaaaaaaaad mooooooooooood.",

                "A SEO expert walks into a bar,\n" +
                        "bars, pub, tavern, public house, \n" +
                        "Irish pub, drinks, beer, alcohol",

                "How does a computer get drunk?\n" +
                        "\n" +
                        "It takes screenshots.",

                "What did the teddy bear say when it was offered some birthday cake?\n" +
                        "\n" +
                        "No thanks, I'm stuffed.",

                "A grasshopper hops into a bar. The bartender says, \n"+
                        "You're quite a celebrity around here. We've even got a drink named after you.\n" +
                        "\n" +
                        "The grasshopper says, \n" + "You've got a drink named Steve?");

        int randomJokeIndex = new Random().nextInt(jokesList.size());

        return jokesList.get(randomJokeIndex);

    }
}
