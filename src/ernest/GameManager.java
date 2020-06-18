package ernest;

import java.util.Arrays;
import java.util.Random;

public class GameManager
{
    private Random rdm;
    private int[] rdmDices;

    private final int AMOUNT_OF_DICES = 5;
    private final int RANGE = 6;
    private final int OFFSET = 1;

    public GameManager()
    {
        rdm = new Random();
        rdmDices = new int[AMOUNT_OF_DICES];
        resetGame();
    }

    public int[] resetGame()
    {
        for (int i = 0; i < AMOUNT_OF_DICES; i++)
            rdmDices[i] = rdm.nextInt(RANGE) + OFFSET;
        
        return rdmDices;
    }
    
    public int[] randomizeDices(int count)
    {
        int[] dices = new int[count];
        
        for (int i = 0; i < count; i++)
        {
            dices[i] = rdm.nextInt(RANGE) + OFFSET;
        }
        
        return dices;
    }
    
    public int[] keepDices(int count)
    {
        int[] dices = new int[count];
        
        for (int i = 0; i < dices.length; i++)
        {
            
        }
        
        return dices;
    }

    /**
     * @return the rdmDices
     */
    public int[] getRdmDices()
    {
        return rdmDices;
    }

    public boolean checkCondition(int[] diceVal, int type)
    {
        int[] threeOfAKindCount = new int[6];
        
        for (int i = 0; i < threeOfAKindCount.length; i++)
            threeOfAKindCount[i] =  0;
        
        for (int i = 0; i < diceVal.length; i++)
        {
            if (diceVal[i] == 1)
                threeOfAKindCount[0]++;
            if (diceVal[i] == 2)
                threeOfAKindCount[1]++;
            if (diceVal[i] == 3)
                threeOfAKindCount[2]++;
            if (diceVal[i] == 4)
                threeOfAKindCount[3]++;
            if (diceVal[i] == 5)
                threeOfAKindCount[4]++;
        }
        
        
        
        for (int x : threeOfAKindCount) {
            if (x >= type)
                return true;
        }
        return false;
    }

    public boolean checkFullHouse(int [] array)
    {
        Arrays.sort(array);
        
        if (((array[0] == array[1]) && (array[1] == array[2]) && (array[3] == array[4]) && (array[2] != array[3])) 
                || ((array[0]==array[1]) && (array[2]==array[3]) && (array[3]==array[4]) && (array[1]!=array[2])))
            return true;
        else
            return false;
    }
    
    public boolean checkStraight(int[] array, int type)
    {
        Arrays.sort(array);
        int follows = 0;

        for (int i = 0; i < array.length; i++)
        {
            if (i + 1 < array.length)
                if (array[i]+1 == array[i+1])
                    follows++;
                
        }
         
        if (follows == type)
            return true;
        else
            return false;
    }

    public boolean checkYahtzee(int[] array)
    {
        int num = array[0];
        
        for (int x : array)
            if (x != num)
                return false;
        
        return true;
    }
    
    public int calcChance(int[] dices)
    {
        int total = 0;
        for (int diceVal : dices)
            total += diceVal;
        
        return total;
    }
}















