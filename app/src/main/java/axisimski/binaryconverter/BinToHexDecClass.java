package axisimski.binaryconverter;
public class BinToHexDecClass {

     private String standardizeInput(String str){

        if(str.charAt(0)=='.'){
            str="0"+str;
        }
        else if(str.charAt(0)=='-'){
            if(str.charAt(1)=='.'){
                str=str.substring(2);
                str="-0."+str;
            }
        }
        return str;
    }

    //Checks if a number is TC ie can not contain '-'
    private Boolean isTwosComplement(String str){

        return str.charAt(0) != '-';
    }

    public String convert(String bin, Integer type, String invalidString){

        bin=standardizeInput(bin);
        String dec="", hex="";
        Bin2Dec bin2Dec =new Bin2Dec();
        Dec2HexTwoComp dec2HexTwoComp=new Dec2HexTwoComp();
        Dec2Hex dec2Hex=new Dec2Hex();

        if(type.equals(0)){

            if(!isTwosComplement(bin)){
                return invalidString;
            }

            dec =bin2Dec.twosComplementToDec(bin);
            Double decimalDouble= bin2Dec.ConvertToDecimal(dec);
            dec=Double.toString(decimalDouble);
            hex= dec2HexTwoComp.convert(dec);
        }

        if(type.equals(1)){
            Double tempDec=bin2Dec.ConvertToDecimal(bin);
            dec=tempDec.toString();
            hex= dec2Hex.convert(dec);
        }

        return "Dec: "+dec+"\nBin: "+bin+"\nHex: "+hex;
    }


}
