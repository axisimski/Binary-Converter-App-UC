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


    public String subOne(String bin){


        int binInt = Integer.parseInt(bin, 2);
        binInt--;
        String ret=Integer.toBinaryString(binInt);



        return ret;
    }


    public String flip(String n){

        char[] myNameChars = n.toCharArray();

        for(int i=0;i<n.length();i++){

            if(n.charAt(i)=='.'){

                break;
            }

            if(n.charAt(i)=='0'){
                myNameChars[i]='1';
            }

            if(n.charAt(i)=='1'){
                myNameChars[i]='0';
            }

        }

        n = String.valueOf(myNameChars);

        return n;
    }



    public String twosComplementToDec(String bin){

        ToBinary fs=new ToBinary();

        boolean negative=true;

        String binFraction=bin;

        if(bin.charAt(0)=='0'){
            negative = false;
            return bin;

        }

        bin=fs.splitString(bin, 0);

        if(Double.parseDouble(binFraction)!=0){

           binFraction= fs.splitString(binFraction, 1);
           binFraction = subOne(binFraction);
           binFraction = flip(binFraction);
        }


       if(Double.parseDouble(binFraction)==0){

           bin = subOne(bin);
           bin = flip(bin);

           if(negative==true){

               bin="-"+bin;
           }
            return bin;

        }

    //    bin = subOne(bin);
      //  bin = flip(bin);


        if(negative==true){

            bin="-"+bin+"."+binFraction;
        }


        return bin;
    }

}
