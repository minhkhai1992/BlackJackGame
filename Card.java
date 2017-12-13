
/**
 * The Card class hold all variable one class suppose to have.
 * The Card class also have getValue, getSuit and getFace where is all value will be return
 * The compareTo method will compare the card have the same value and check which one higher.
 * 
 * @author (Khai Lim)
 * @version (12/5/2017)
 */
public class Card
{
    private int value; // declare the card value has private access with integer
    private char suit; // declare the card suit has private access with character
    private char face; // declare the card face has private access with character
    
    /**
     * This constructor takes three variables value, suit and face
     * that what one card always has.
     * @param int v - the number will store in value of the cards
     * char s - the character will store in suit of the cards
     * char f - the character will store in the face of the cards.
     */
    public Card(int v, char s, char f)
    {
        value = v;
        suit = s;
        face = f;    
    }
    
    /**
     * The method will return the getValue of the card back to integer
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     * The method will return the getSuit of the card back to character
     */
    public char getSuit()
    {
        return suit;
    }
    
    /**
     * The method will return the getFace of the card back to character
     */
    public char getFace()
    {
        return face;
    }
    
    /**
     * The toString method will display all value we had in class out
     * return to String
     */
    public String toString()
    {
         return this.face + " " + this.suit + " value: " + this.value;
    }
    
    /**
     * The compareTo method will compare between two value and check the face of cards
     * to see which one has higher face
     * return the result back to integer.
     */
    public int compareTo(Card other)
    {
        int result = 0;
        if (this.value > other.value)
        {
            result = 1;
        }
        else if (this.value == other.value)
        {
            if (this.value == 10)
            {                    
                if (this.face == 'K')
                {
                    if (other.face == 'K')
                    {
                        result = 0;
                    }
                    else
                    {
                        result = -1;
                    }
                }
                else if(this.face == 'Q')
                {
                    if (other.face == 'K')
                    {
                        result = -1;
                    }
                    else if (other.face == 'J')
                    {
                        result = 1;
                    }
                    else
                    {
                        result = 0;
                    }
                }
                else if (this.face == 'J')
                {
                    if (other.face == 'K' || other.face == 'Q')
                    {
                        result = -1;
                    }
                    else if (other.face == 'T')
                    {
                        result = 1;
                    }
                    else
                    {
                        result = 0;
                    }
                }
                else if (this.face == 'T')
                {
                    if (other.face == 'K' || other.face == 'Q' || other.face == 'J')
                    {
                        result = -1;
                    }
                    else
                    {
                        result = 0;
                    }
                }
            }
            else
            {
                result = 0;
            }
        }
        else
        {
            result = -1;
        }
        
        return result;
    }
    
}
