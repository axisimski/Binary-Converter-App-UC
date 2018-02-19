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

        ToBinary bin=new ToBinary();
        bin.execute();

    }
    //====================================================================end of toBinary

    public void toDecimal (View v){

        ToDecimal dec=new ToDecimal();
        dec.execute();

    }

}


