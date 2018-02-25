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



    public String twosComplementToDec(String bin){

        ToBinary fs=new ToBinary();

        String binFraction=bin;
        binFraction= fs.splitString(binFraction, 1);
        bin=fs.splitString(bin, 0);




        return bin;
    }

}
