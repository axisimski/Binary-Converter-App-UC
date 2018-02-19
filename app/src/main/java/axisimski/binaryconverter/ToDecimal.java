package axisimski.binaryconverter;

import static axisimski.binaryconverter.MainActivity.input;

/**
 * Created by Alex on 2/18/2018.
 */

public class ToDecimal {

    public void execute(){
        if(!input.getText().toString().isEmpty()){

            if(!input.getText().toString().matches("[01]+")){

                input.setError("Must be a binary number!");
            }

            else{
               String value= input.getText().toString();
               int n=Integer.parseInt(value, 2);
               String decimalString;
               decimalString=Integer.toString(n);
               MainActivity.output.setText(decimalString);
               input.setText("");
            }
        }


    }//==================================================================================

    public static int getTwosComplement(String binaryInt) {

        if (binaryInt.charAt(0) == '1') {

            String invertedInt = invertDigits(binaryInt);
            int decimalValue = Integer.parseInt(invertedInt, 2);

            decimalValue = (decimalValue + 1) * -1;
            return decimalValue;
        } else {

            return Integer.parseInt(binaryInt, 2);
        }
    }

    public static String invertDigits(String binaryInt) {
        String result = binaryInt;
        result = result.replace("0", " ");
        result = result.replace("1", "0");
        result = result.replace(" ", "1");
        return result;
    }



}
