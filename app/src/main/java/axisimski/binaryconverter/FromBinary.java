package axisimski.binaryconverter;
public class FromBinary {

    String InvalidInput = MainActivity.invalidNumber;
    String InputTooLarge=MainActivity.inputTooLarge;

    public boolean isBinary(String str){

        return str.matches("[-.01]+");

    }

    public boolean isValidNumber(String str){

        int DotCount=0, MinusCount=0;

        for(int i=0;i<str.length();i++){

            if(str.charAt(i)=='.'){
                DotCount++;
            }

            if(str.charAt(i)=='-'){
                MinusCount++;
            }

            if(DotCount>1){
                return false;
            }

            if(MinusCount>1){
                return false;
            }

        }

        return  true;

    }

    public String standardizeInput(String str){

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

    public Boolean isTwosComplement(String str){

        if(str.charAt(0)=='-'){
            return false;
        }
        return true;
    }

    public String convert(String bin, Integer type){

        //Catch input which can crash the app
        if(isBinary(bin)==false){
            return InvalidInput;
        }

        if(!isValidNumber(bin)){
            return InvalidInput;
        }

        bin=standardizeInput(bin);



        String dec="", hex="";
        Bin2Dec bin2Dec =new Bin2Dec();
        Dec2HexTwoComp dec2HexTwoComp=new Dec2HexTwoComp();
        Dec2Hex dec2Hex=new Dec2Hex();

        if(type.equals(0)){

            if(!isTwosComplement(bin)){
                return InvalidInput;
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

        String ret="Dec: "+dec+"\nBin: "+bin+"\nHex: "+hex;
        return ret;
    }





}
