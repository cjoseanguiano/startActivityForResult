package com.devix.www.startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int CODIGO_DEL_TEXTO = 1;
    private Button btnImplicit;
    private Button btnIntents;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImplicit = (Button) findViewById(R.id.buttonImplicitIntent);
        btnIntents = (Button) findViewById(R.id.buttonUsandoIntents);
        txtResult = (TextView) findViewById(R.id.textViewResultado);

        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImplicitActivity.class);
                startActivityForResult(intent, CODIGO_DEL_TEXTO);

            }
        });

        btnIntents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODIGO_DEL_TEXTO && resultCode == RESULT_OK) {
            String txtNombre = data.getStringExtra("uno");
            String txtApelldio = data.getStringExtra("dos");
            txtResult.setText(txtNombre + " " + txtApelldio);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
