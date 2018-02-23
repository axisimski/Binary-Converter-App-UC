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


        //=============================================================================Convert to twos complement
        public String toTwosComplement(String  bin){


            Character n=bin.charAt(0);

            if(n!='-'){
              bin = "0"+bin;
            }

            else if(n=='-'){

              bin = bin.replace("-","");

                bin = bin.substring(0, bin.indexOf('.'));


                int digits=bin.length();


              while(digits%4!=0){

                  bin="0"+bin;
                  digits=bin.length();


              }




             bin= flip(bin);

              return bin;

            }


            return  bin;
        }


}



