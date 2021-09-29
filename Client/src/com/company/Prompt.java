package com.company;

import java.util.Scanner;

public class Prompt {
    String promptText;

    String prompt1 = "Tell a funny joke!";
    String prompt2 = "I was afraid of (blank)";

    String[] prompts = {prompt1, prompt2};

    String randomPrompt;


    public void choosePrompt(){

    }

    public void askPrompt(){
        System.out.print(randomPrompt);
        java.util.Scanner in = new Scanner(System.in);
        name = in.next();
    }
    }


}
