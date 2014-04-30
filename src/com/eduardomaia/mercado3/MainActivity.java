package com.eduardomaia.mercado3;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("DefaultLocale")
public class MainActivity extends Activity {

    @SuppressLint("DefaultLocale")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		final Button loadButton = (Button) findViewById(R.id.button1);
		loadButton.setOnClickListener(new OnClickListener() {
			@SuppressLint("DefaultLocale")
			@Override
			public void onClick(View v) {
				
				// quantas g/ml tem no pacote 
				EditText gml;
				gml   = (EditText)findViewById(R.id.editText1);
				
				//qual preço do pacote
				EditText preco;
				preco   = (EditText)findViewById(R.id.editText2);

				if (!preco.getText().toString().isEmpty() && !gml.getText().toString().isEmpty())
				{
					//regra de 3:
					//350 g (gml) -> preço do pacote (preco)
					// 1 Kg -> preco_kilo_litro
					float preco_kilo_litro = 1000 * Float.valueOf(preco.getText().toString()) / Float.valueOf(gml.getText().toString());
					String strpreco=preco_kilo_litro+"";
					strpreco = String.format("%.2f", preco_kilo_litro);
					
					TextView answerView = (TextView) findViewById(R.id.textView8);
					answerView.setText("R$ " + strpreco);
				}
			}
		});

		
		final Button resetButton = (Button) findViewById(R.id.button2);
		resetButton.setOnClickListener(new OnClickListener() {
			@SuppressLint("DefaultLocale")
			@Override
			public void onClick(View v) {
				
				TextView answerView = (TextView) findViewById(R.id.textView8);
				answerView.setText("R$ ...");
				
				EditText e1 = (EditText)findViewById(R.id.editText1);
				e1.setText("");

				EditText e2 = (EditText)findViewById(R.id.editText2);
				e2.setText("");
				
			}
		});
		
		
    }

    
    
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
