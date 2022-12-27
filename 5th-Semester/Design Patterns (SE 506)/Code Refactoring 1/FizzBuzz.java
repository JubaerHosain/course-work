public class FizzBuzz {
    public static String say(int number) {
        String strReturn = null;

        if (IsDevisibleBy(number,15)) 
            strReturn = "FizzBuzz";
        else if (IsDevisibleBy(number,3)) 
            strReturn = "Fizz";

        else if (IsDevisibleBy(number,5)) 
            strReturn = "Buzz";
        

        if (strReturn != null) return strReturn;

        return String.valueOf(number);
    }

    public static boolean IsDevisibleBy(int number, int devisor){
        if(number%devisor==0)
            return true;
        else 
            return false;
    }
}


