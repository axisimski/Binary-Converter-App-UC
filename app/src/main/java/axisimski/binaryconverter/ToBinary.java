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

    //=============================================================================Split fractional part

        public String splitString (String bin, int index){

             String[] parts = bin.split("[.]");
             bin = parts[index];

            return bin;
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

                bin = bin.indexOf(".") < 0 ? bin : bin.replaceAll("0*$", "").replaceAll("\\.$", "");

                bin="0"+bin;

                int digits=bin.length();


              while(digits%4!=0){

                  bin="0"+bin;
                  digits=bin.length();
              }


              bin = flip(bin);
              bin = addOne(bin);

            }



            return  bin;
        }


}



