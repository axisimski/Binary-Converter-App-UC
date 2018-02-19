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

    }

}
