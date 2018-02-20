package axisimski.binaryconverter;

import static axisimski.binaryconverter.MainActivity.input;

/**
 * Created by Alex on 2/18/2018.
 */

public class ToDecimal {



    public double ConvertToDecimal(String a){
        double sum;
        if(a.contains(".")){
            String[] b=a.split("\\.");

            int sum1=Integer.parseInt(b[0],2);


            double sum2=latterPart(b[1]);

            sum=sum1+sum2;

        }else{
            sum=Integer.parseInt(a,2);
        }
        return sum;
    }
    public  double latterPart(String number){
        double sum=0;
        int length=number.length();
        for(int i=0;i<length;i++){
            int e=-i-1;
            char mult=number.charAt(i);
            int num=Integer.parseInt(String.valueOf(mult));
            double num1=num*Math.pow(2, e);
            sum=sum+num1;;
        }
        return sum;
    }











    /*public void execute(){
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
    }*/



}
