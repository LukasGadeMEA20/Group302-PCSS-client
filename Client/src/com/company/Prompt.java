package com.company;
import java.util.Random;

import java.util.Scanner;

public class Prompt {
    String promptText;

    String prompt1 = "Tell a funny joke!";
    String prompt2 = "I was afraid of (blank)";

    String[] prompts = {prompt1, prompt2};

    String randomPrompt;

    String answer;

    Random random=new Random();
    int min=1;
    int max=2;

    public void choosePrompt() {
        for (int i = 1; i <= 10; i++) {
            int randomNum = random.nextInt(prompts.length);
            randomPrompt = prompts[randomNum].toString();
            //System.out.println(prompts[randomPrompt].toString());
        }
    }
}

