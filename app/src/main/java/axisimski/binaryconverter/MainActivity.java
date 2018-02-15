package axisimski.binaryconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText binary;
    EditText decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binary=(EditText) findViewById(R.id.binary);
        decimal=(EditText)findViewById(R.id.decimal);
    }

    //Perform conversion
    public void convert(View v){

        if(!decimal.getText().toString().isEmpty()){

            String value= decimal.getText().toString();
            int n=Integer.parseInt(value);
            String binaryString;
            binaryString=Integer.toBinaryString(n);
            binary.setText(binaryString);
            decimal.setText("");
        }


        else if(!binary.getText().toString().isEmpty()){

            String value= binary.getText().toString();
            int n=Integer.parseInt(value, 2);
            String decimalString;
            decimalString=Integer.toString(n);
            decimal.setText(decimalString);
            binary.setText("");
        }



    }
    //====================================================================end of convert

}
