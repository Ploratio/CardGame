package Game;


public class Card {
    private String[] possibleColours = {"Hearts", "Spades", "Diamonds", "Clubs"};

    private String colour;
    private int value;

    Card(int value, int colour) {
        this.value = value;
        this.colour = possibleColours[colour];
    }

    public String getColour() {
        return colour;
    }

    public int getValue() {
        return value;
    }
}
