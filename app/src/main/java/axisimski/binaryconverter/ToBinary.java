package axisimski.binaryconverter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Alex on 2/18/2018.
 */

public class ToBinary {


        public String convert(double number) {
            int n = 10;

            BigDecimal bd = new BigDecimal(number);

            BigDecimal mult = new BigDecimal(2).pow(n);

            bd = bd.multiply(mult);

            BigInteger bi = bd.toBigInteger();

            StringBuilder str = new StringBuilder(bi.toString(2));

            while (str.length() < n+1) {
                str.insert(0, "0");
            }
            str.insert(str.length()-n, ".");
            return str.toString();
        }

//=================================================================Flip

        public String addOne(String bin){


            int binInt = Integer.parseInt(bin, 2);
            binInt++;
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

    //=============================================================================Split string to extract the fractional part

        public String splitString (String bin, int index){

             String[] parts = bin.split("[.]");
             bin = parts[index];

            return bin;
        }


        public String convert(String bin){

            String binFraction=bin;
            binFraction= splitString(binFraction, 1);
            bin = splitString(bin, 0);


            if(Double.parseDouble(binFraction)==0){

                return bin;

            }

            else return bin+"."+binFraction;


        }


        //=============================================================================Convert to twos complement

        public String toTwosComplement(String  bin){

            String binFraction=bin;
            binFraction= splitString(binFraction, 1);

            if(bin.charAt(0)!='-'){

              bin = "0"+bin;
            }

            else if(bin.charAt(0)=='-'){

                bin = bin.replace("-","");

                bin = splitString(bin, 0);
                bin="0"+bin;

                int digits=bin.length();


              while(digits%4!=0){

                  bin="0"+bin;
                  digits=bin.length();
              }

                String fracVal=binFraction;
                binFraction = flip(binFraction);
                binFraction = addOne(binFraction);
                bin = flip(bin);

                if(Double.parseDouble(fracVal)==0){

                    bin = addOne(bin);
                    return bin;

                }


              bin=bin+"."+binFraction;
            }


            return  bin;
        }


}



