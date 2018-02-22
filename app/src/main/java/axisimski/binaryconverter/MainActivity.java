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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input=(EditText) findViewById(R.id.input);
        output=(TextView)findViewById(R.id.output);
        twosComplement=(RadioButton)findViewById(R.id.twosComplement);
        signedNum=(RadioButton)findViewById(R.id.signeNum);

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
                MainActivity.output.setText(binString);
            }

            else if(twosComplement.isChecked()){

                MainActivity.output.setText("Under Construction");
            }

            else{
                MainActivity.output.setText("Select something");

            }


        }

    }
    //====================================================================end of toBinary

    public void toDecimal (View v){


        if(!input.getText().toString().isEmpty()){

            if(!input.getText().toString().matches("[0.1-]+")){

                input.setError("Must be a binary number!");
            }

            else{

                if(twosComplement.isChecked()){
                  ToDecimal dec=new ToDecimal();
                  Double decimalString= dec.ConvertToDecimal(input.getText().toString());
                  String dectoString=decimalString.toString();
                  MainActivity.output.setText(dectoString);
                }

                else if(twosComplement.isChecked()){

                    MainActivity.output.setText("Under Construction");
                }

                else{
                    MainActivity.output.setText("Select something");

                }
            }
        }
    }
    //====================================================================end of toDecimal

}


