

import java.util.Random;

public abstract class Card {
    //    private String owner, cardFace;
    private static int nextNum = 123243445;
    private final int cardNum;


    public Card() {

        this.cardNum = new Random().nextInt(nextNum++);
    }

    public abstract String getCardType();



    public int getCardNum() {
        return this.cardNum;
    }


}