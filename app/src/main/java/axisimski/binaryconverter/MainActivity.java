package axisimski.binaryconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

   static EditText input;
   static TextView output;
   static RadioButton twosComplement;
   static RadioButton signedNum;

   static String makeSelection, mustBeBinary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input=(EditText) findViewById(R.id.input);
        output=(TextView)findViewById(R.id.output);
        twosComplement=(RadioButton)findViewById(R.id.twosComplement);
        signedNum=(RadioButton)findViewById(R.id.signeNum);

        makeSelection=getResources().getString(R.string.makeSelection);
        mustBeBinary=getResources().getString(R.string.mustBeBinary);

    }

    //Perform conversion
    public void toBinary (View v){

        if(input.getText().toString().isEmpty()) {

            return;
        }
        else{

            if(signedNum.isChecked()){

                ToBinary bin=new ToBinary();
                String binString = bin.convert(Double.parseDouble(input.getText().toString()));
                binString=bin.convert(binString);
                MainActivity.output.setText(binString);
            }

            else if(twosComplement.isChecked()){

                //Works the first time, but app will crash if the user keeps trying to enter out of bounds input!!!
                if(Double.parseDouble(input.getText().toString())>99999999.999||
                        Double.parseDouble(input.getText().toString())<-99999999.999){
                    input.setError("-100,000,000< N < 100,000,000");
                 }

                else  {

                    ToBinary bin = new ToBinary();
                    String bs = bin.convert(Double.parseDouble(input.getText().toString()));
                    String ns = bin.toTwosComplement(bs);
                    MainActivity.output.setText(ns);
                }
            }

            else{
                MainActivity.output.setText(makeSelection);

            }

        }

    }
    //====================================================================end of toBinary

    public void toDecimal (View v){

        if(!input.getText().toString().isEmpty()){

            if(!input.getText().toString().matches("[0.1-]+")){

                input.setError(mustBeBinary);
            }

            else{

                if(signedNum.isChecked()){
                  ToDecimal dec=new ToDecimal();
                  Double decimalString= dec.ConvertToDecimal(input.getText().toString());
                  String dectoString=decimalString.toString();
                  MainActivity.output.setText(dectoString);
                }

                else if(twosComplement.isChecked()){


                    ToDecimal dec = new ToDecimal();
                    String ns = dec.twosComplementToDec(input.getText().toString());
                    Double decimalDouble= dec.ConvertToDecimal(ns);
                    String ds=Double.toString(decimalDouble);



                    MainActivity.output.setText(ds);
                }

                else{
                    MainActivity.output.setText(makeSelection);

                }
            }
        }
    }
    //====================================================================end of toDecimal

}


