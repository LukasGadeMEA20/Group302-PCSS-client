package com.company;
import java.util.Random;

public class Prompt {
    String promptText;
    
    String prompt1 = "Tell a funny joke!";
    String prompt2 = "I was afraid of (blank)";
    
    String[] prompts = {prompt1, prompt2};

    Random random=new Random();
    int min=1;
    int max=2;
    
    
    public void choosePrompt() {
        for(int i = 1; i <=10; i++) {
            int randomPrompt = random.nextInt(prompts.length);
            System.out.println(prompts[randomPrompt]);
        }
    }
    
    public void delegatePoints(){

    }
}
