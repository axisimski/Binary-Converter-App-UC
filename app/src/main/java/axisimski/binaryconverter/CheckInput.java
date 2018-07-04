package axisimski.binaryconverter;

import android.content.Context;

public class CheckInput {

    public String validInput(String input, int type, Context context){

        //Decimal Input
        if(type==2){
            if(!isNumeric(input)){
                return context.getResources().getString(R.string.notvalid);
            }
            if(input.length()>10){
                return context.getResources().getString(R.string.inputTooLarge);
            }
        }

      //  if(type==1){

      //  }



        return "OK";
    }

//==================================================================================================
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

}
