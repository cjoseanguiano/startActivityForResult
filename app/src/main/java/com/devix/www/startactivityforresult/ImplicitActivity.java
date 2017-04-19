package com.devix.www.startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ImplicitActivity extends AppCompatActivity {

    private TextView txtNombreImp;
    private TextView txtApellidoImp;
    private Button btnEnviarImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        txtNombreImp = (TextView) findViewById(R.id.textViewNombre);
        txtApellidoImp = (TextView) findViewById(R.id.textViewApellido);
        btnEnviarImp = (Button) findViewById(R.id.buttonEnviarResultados);

        btnEnviarImp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreIm = txtNombreImp.getText().toString();
                String apellidoIm = txtApellidoImp.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("uno", nombreIm);
                resultIntent.putExtra("dos", apellidoIm);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
