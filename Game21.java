import java.util.*;
/**
 * The Game21 is a driver contain main, and method to check total cards of Dealer and Player
 * The Driver use base on BlackJack game in relistic that have all function shuffle cards and
 * check who will be win and count/print out the result who wins the most.
 * The Driver also allow user to pick to continous playing or quit a game.
 * 
 * @author (Khai Lim)
 * @version (12/5/2017)
 */
public class Game21
{
    static Deck myDeck = new Deck();    //a reference that will point to an Deck object.
    static Card[] dealer = new Card[5]; //create dealer object in arrays of Card class.
    static Card[] player = new Card[5]; //create player object in arrays of player class
    static int dealer_next = 2;         //make dealer integer assume that dealer already have 2 cards
    static int player_next = 2;         //make player integer assume that player already have 2 cards
    static int dealer_won = 0;          //Variable hold the number dealer wins in game.
    static int player_won = 0;          //Variable hold the number player wins in game.
    
    /**
     * The static methods will hold the total value of dealer
     * that the method will be call in class for convenience.
     * The method will calculate and add all number dealer got.
     * Instances methods are associated with objects and the name implies can use instance variables.
     */
    public static int getDealerTotal()
    {
        int dealer_total = 0;
        for (int i = 0; i<dealer_next; i++)
        {
            if (dealer[i].getSuit() == 'A' && i >= 2)
            {
                dealer_total += 1;
            }
            else if (dealer[i].getSuit() == 'A' && i < 2)
            {
                dealer_total += 11;
            }
            else
            {
                dealer_total += dealer[i].getValue();
            }
        }
        return dealer_total;
    }
    
    /**
     * The static methods will hold the total value of player
     * that the method will be call in class for convenience.
     * The method will calculate and add all number player got.
     * Instances methods are associated with objects and the name implies can use instance variables.
     */
    public static int getPlayerTotal()
    {
        int player_total = 0;
        for (int i = 0; i<player_next; i++)
        {
            if (player[i].getSuit() == 'A' && i >= 2)
            {
                player_total += 1;
            }
            else if (player[i].getSuit() == 'A' && i < 2)
            {
                player_total += 11;
            }
            {
                player_total += player[i].getValue();
            }
        }        
        return player_total;
    }
    
    
    /**
     * The main method where is the program will access to run.
     * The main method will start the game and call out another method from Deck class and Card class
     * The method will answer user still want playing or quit a game.
     */
    public static void main (String[] args)
    {
        //local variable
        boolean continuePlaying = true;         // to keep track game continuous or stop
        Scanner input = new Scanner(System.in); // create Scanner to get user input
        int dealer_total = 0;                   // to store the total dealer wons
        int player_total = 0;                   // to store te total player wons
        
        //get loop will check the user input to continous the game or stop.
        while (continuePlaying)
        {
            myDeck = new Deck(); // a reference that will point to an Deck object in default
            dealer_next = 2;     // assume that dealer already has 2 cards
            player_next = 2;     // assume that player already has 2 cards
            
            myDeck.shuffle();    // shuffle the deck cards before play.
            
            System.out.println("\t\t\t---------------Welcome to Black Jack's Khai Lim Game---------------");
            System.out.println("\t\t\tThe Game is base on realistic what is the happen in real life game");
            System.out.println("The Dealer completed take out 1st card");
            dealer[0] = myDeck.getTopCard(); // The 1st card for dealer
            
            System.out.println("The Player completed take out 1st card");
            player[0] = myDeck.getTopCard();  // the 1st cards for player
            
            System.out.println("The Dealer completed take out 2nd card");
            dealer[1] = myDeck.getTopCard();   // The 2nd cards for dealer
            
            System.out.println("The Player completed take out 2nd card\n");
            player[1] = myDeck.getTopCard();    // The 2nd cards for player
            
            dealer_total = getDealerTotal(); // store the dealer total of 2 cards
            //The loop keep check if the total of 2 cards less than 17 then keep draw another card.
            while (dealer_total < 17)
            {
                dealer[dealer_next++] = myDeck.getTopCard();
                dealer_total = getDealerTotal();
            }
            
            //The loop will run the while loop fault with yes to display all cards Dealer and player had
            char userInput = 'Y';
            while (userInput == 'Y')
            {
                System.out.println("You currently have " + player_next + " cards");
                for (int i = 0; i<player_next; i++)
                {
                    System.out.println(player[i]);
                }
                System.out.println("Your Total is: " + getPlayerTotal());
                // The loop will keep ask user for get more card.
                do 
                {
                    System.out.print("Do you want to get more card: (Y for Yes and N for No )");
                    userInput = input.next().toUpperCase().charAt(0); // covert all user input be Upper case and pick first character
                }while(userInput != 'Y' && userInput != 'N' );
                
                if (userInput == 'Y')
                {
                    player[player_next++] = myDeck.getTopCard();
                }
            }
            System.out.println("------------------------------------------------");
            System.out.println("Your current hand");
            for (int i = 0; i<player_next; i++)
            {
                System.out.println(player[i]);
                
            }
                    
            // display the dealer cards
            System.out.println("Dealer Hands");
            for (int i = 0; i<dealer_next; i++)
            {
                System.out.println(dealer[i]);
                
            }
                
                
            dealer_total = getDealerTotal(); // use the getDealer total to calculate dealer total
            player_total = getPlayerTotal(); // use the getPlayer total to calculate player total
            System.out.println("------------------------------------------------");
            //The program will check all condition who is greater than.
            if (dealer_total > 21 && player_total > 21)
            {
                System.out.println("Dealer Busted");
                System.out.println("Player Busted");
                System.out.println("No One Won");
            }
            else if (dealer_total > 21 && player_total <= 21)
            {
                System.out.println("Dealer Busted");
                System.out.println("Player Won");
                player_won++;
            }
            else if (dealer_total <= 21 && player_total > 21)
            {
                System.out.println("Dealer Won");
                System.out.println("Player Busted");
                dealer_won++;
            }
            else
            {
                if (dealer_total  > player_total)
                {
                    System.out.println("Dealer Won");
                    dealer_won++;                
                }
                else if (dealer_total  < player_total)
                {
                    System.out.println("Player Won");
                    player_won++;
                }
                else
                {
                    System.out.println("Draw. No One Won");
                }
            }
            System.out.print("\nDo u want to play again: Y/N: ");
            userInput = input.next().toUpperCase().charAt(0); // convert userInput to keep play the game
                    
            if (userInput == 'N')
            {
                continuePlaying = false;
            }
        }
        System.out.println("\t\t\tStatistics");
        System.out.println("\t\t\tPlayer won: " + player_won + " games");
        System.out.println("\t\t\tDealer won: " + dealer_won + " games");
    }   
}