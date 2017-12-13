import java.util.*;
/**
 * The Deck class will store and calculate all a class contain Value, Suit, Face.
 * The Deck class hold the shuffle function that will make shuffle before pass the card out.
 * 
 * @author (Khai Lim)
 * @version (12/5/2017)
 */
public class Deck
{
    private Card[] deck; // a reference that will point to an card arrays object
    Random rdm = new Random(); // create a random function
    int top = 0;                // store the top with integer for used in copy method
    
    /**
     * The no-args constructor sets the card values with default 
     * base on realistic Deck card
     * They also have a function of deck cards that will be loop 52 times.
     */
    public Deck()
    {
        deck = new Card[52];
        for (int i = 0; i < deck.length; i++)
        {
            deck[i] = new Card (getValue(i), getSuit(i), getFace(i));
        }
        
    }
    
    /**
     * The getValue of the card will calculate value of the card
     * start from 2 to 52 cards
     * The method used base on algorithm to calculate and return the value back to integer 
     * @param number - a integer representation the number from 0 - 52
     * return result with integer number to find out the true card number
     */
    private int getValue(int number)
    {
        int result = (number % 13 ) + 2;
        if (result > 10)
        {
            if(result == 14)
            {
                result = 11;
            }
            else
            {
                result = 10;
            }
        }
        return result;
    }
    
    /**
     * The getSuit of the card will use the number of the card
     * start from 0 to 52 cards to find out what the type of the cards
     * The method used base on algorithm to calculate and return the value back to character 
     * @param number - a int representation the number from 0 - 52
     * return result with character to find out the individual cards suit.
     */
    private char getSuit(int number)
    {
        char result;
        switch((number/13)%4)
        {
            case 0: result = 'S'; break;
            case 1: result = 'H'; break;
            case 2: result = 'C'; break;
            case 3: result = 'D'; break;
            default: result = 'X';
        
        }
        return result;
    }
    
    /**
     * The getFace of the card will calculate value of the card
     * start from 0 to 12 to split and what is individual face of each card
     * The method used base on algorithm to calculate and return the value back to character 
     * @param number - a integer representation the number from 0 - 52
     * return result with character to find out the true card number
     */
    private char getFace(int number)
    {
        char result;
        switch(number%13)
        {
            case 0: result = '2'; break;
            case 1: result = '3'; break;
            case 2: result = '4'; break;
            case 3: result = '5'; break;
            case 4: result = '6'; break;
            case 5: result = '7'; break;
            case 6: result = '8'; break;
            case 7: result = '9'; break;
            case 8: result = 'T'; break;
            case 9: result = 'J'; break;
            case 10: result = 'Q'; break;
            case 11: result = 'K'; break;
            case 12: result = 'A'; break;
            default: result = 'X';                
        }
        return result;
    }
    
    /**
     * The method will copy the old card to new card to use in game
     * return newCard back to Card class
     */
    public Card getTopCard()
    {        
        Card oldCard = deck[top++]; // get next card everytime
        Card newCard = new Card(oldCard.getValue(),oldCard.getSuit(),oldCard.getFace());
        return newCard;
    }
    
    /**
     * The method shuffle will shuffle all cards in the deck in 1000 times
     * In the shuffle method has random function that will pick randomly 2 numbers
     * The method also had the swap the smallest value with the value in the starting position
     */
    public void shuffle()
    {       
        for (int i = 0; i < 1000; i++)
        {
            int num1,num2;
            num1 = rdm.nextInt(52);
            num2 = rdm.nextInt(52);
            
            Card temp = deck[num1];
            deck[num1] = deck[num2];
            deck[num2] = temp;
        }
    }
    
    /**
     * The toString method will bring out all variables in the Deck class
     * return to String.
     */
    public String toString()
    {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < this.deck.length; i++)
        {
            result.append(this.deck[i].toString() + "\n");
        }
        return result.toString();
    }
}
