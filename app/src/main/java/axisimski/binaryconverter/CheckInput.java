package axisimski.binaryconverter;

import android.content.Context;

public class CheckInput {

    //NOTE: input types here are not the same thing as the input  types in Main.
    //Here they refer solely to what button has been pressed. (DEC,BIN,HEX).
    public String validInput(String input, int type, Context context){

        //Decimal Input
        if(type==2){
            if(!isNumeric(input)){
                return context.getResources().getString(R.string.notvalid);
            }
            else if(input.length()>10){
                return context.getResources().getString(R.string.inputTooLarge);
            }
        }

        //Binary input
        if(type==1){
            if(!isBinary(input)){
                return context.getResources().getString(R.string.notvalid);
            }
            else if(!isValidNumber(input)){

                return context.getResources().getString(R.string.notvalid);
            }
        }



        return "OK";
    }

//==================================================================================================

   //Checks decimal numbers
    private boolean isNumeric(String str){
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
//==================================================================================================

    //Checks inf input type 1 (binary) is in fact binary
    private boolean isBinary(String str){
        return str.matches("[-.01]+");
    }

    //Checks if something is a valid number (Does not contain more than one '.') ...used for bin check
    private boolean isValidNumber(String str){

        int DotCount=0, MinusCount=0;

        for(int i=0;i<str.length();i++){

            if(str.charAt(i)=='.'){
                DotCount++;
            }

            if(str.charAt(i)=='-'){
                MinusCount++;
            }

            if(DotCount>1){
                return false;
            }

            if(MinusCount>1){
                return false;
            }

        }

        return  true;
    }


}//end class()
