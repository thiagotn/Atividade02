package cc.thiago.atividade02;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private TextView txtNumero;

    public void somar(View v) {
        Integer val = Integer.parseInt(txtNumero.getText().toString());
        val++;
        txtNumero.setText(String.valueOf(val));
    }

    public void menos(View v) {
        Integer val = Integer.parseInt(txtNumero.getText().toString());
        val--;
        txtNumero.setText(String.valueOf(val));
    }

    public void zerar(View v) {
        txtNumero.setText(String.valueOf(0));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtNumero = (TextView) findViewById(R.id.txtNumero);
        if (savedInstanceState != null) {
            txtNumero.setText(savedInstanceState.getString("valor"));
        } else {
            txtNumero.setText(R.string.txtZero);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        txtNumero = (TextView) findViewById(R.id.txtNumero);
        outState.putString("valor", txtNumero.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
