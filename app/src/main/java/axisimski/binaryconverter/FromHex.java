package axisimski.binaryconverter;
public class FromHex {

    String InvalidInput = MainActivity.invalidNumber;
    String InputTooLarge=MainActivity.inputTooLarge;

    //======================================================================================================

    public boolean isHex(String str){
        return str.matches("-?[0-9a-fA-F.]+");
    }

    //======================================================================================================
    public boolean tooLarge(String str){

        String whole="", part="";

        if(str.contains(".")){
            String[] parts = str.split("[.]");


            if(parts[0].length()>7){
                    return true;
            }
            if(parts[1].length()>7){
                return true;
            }
        }

        else if(!str.contains(".")){
            if(str.length()>7){
                return true;
            }
        }

        return false;
    }
//=======================================================================================================

    public String convert(String hex, Integer type){

        if(isHex(hex)==false){
           return InvalidInput;
        }
        if(tooLarge(hex)==true){
            return InputTooLarge;
        }
        if(type.equals(0)&&hex.contains("-")){
            return InvalidInput;
        }



        Hex2Bin hex2Bin= new Hex2Bin();
        Bin2Dec bin2Dec= new Bin2Dec();
        Bin2TwosComp bin2TwosComp =new Bin2TwosComp();

        String dec="", bin="";


        if(type.equals(0)){

             bin=hex2Bin.convert(hex);

             String bintemp=bin2Dec.twosComplementToDec(bin);
             Double tempDec=bin2Dec.ConvertToDecimal(bintemp);
             dec=tempDec.toString();
            //dec=bintemp;


         }


         if(type.equals(1)){
             bin=hex2Bin.convert(hex);
             Double tempDec=bin2Dec.ConvertToDecimal(bin);
             dec=tempDec.toString();

         }



        String ret="Dec: "+dec+"\nBin: "+bin+"\nHex: "+hex;
        return ret;
    }


}
