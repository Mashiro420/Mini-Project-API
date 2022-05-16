package Utils;

import java.util.Random;

public class GeneralEmail {
    Random rand = new Random();

    public String randomEmail(){
        return "difa" + rand.nextInt(1000) + "@email.com";
    }
}
