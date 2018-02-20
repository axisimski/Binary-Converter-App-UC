package axisimski.binaryconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

   static EditText input;
   static TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input=(EditText) findViewById(R.id.input);
        output=(TextView)findViewById(R.id.output);
    }

    //Perform conversion
    public void toBinary (View v){

        if(input.getText().toString().isEmpty()) {

            return;
        }


        else{
                ToBinary bin=new ToBinary();
                String binString = bin.convert(Double.parseDouble(input.getText().toString()));
                MainActivity.output.setText(binString);
        }

    }
    //====================================================================end of toBinary

    public void toDecimal (View v){


        if(!input.getText().toString().isEmpty()){

            if(!input.getText().toString().matches("[0.1-]+")){

                input.setError("Must be a binary number!");
            }

            else{
                ToDecimal dec=new ToDecimal();
                Double decimalString= dec.ConvertToDecimal(input.getText().toString());
                String dectoString=decimalString.toString();
                MainActivity.output.setText(dectoString);
            }
        }
    }
    //====================================================================end of toDecimal

}


