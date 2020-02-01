package bilkent.edu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static bilkent.edu.myapplication.R.layout.activity_main2;
import static java.lang.Integer.parseInt;

public class Main2Activity extends AppCompatActivity {
    private TextView textViewKalanHak, textViewYardim;
    private EditText editTextGirdi;
    private Button buttonTahmin;
    private int sayac;
    private int sayı;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttonTahmin = findViewById(R.id.buttonTahmin);
        editTextGirdi = findViewById(R.id.editTextGirdi);
        textViewKalanHak = findViewById(R.id.textViewKalanHak);
        textViewYardim = findViewById(R.id.textViewYardim);
        sayac = 5;
        Random r = new Random();
        sayı = r.nextInt(101);

        Log.e("sayı","sayı = "+sayı);

        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((editTextGirdi.getText().toString())!= null)
                {
                    sayac--;
                    textViewKalanHak.setText("Kalan Hak\n" + sayac);
                    Intent a = new Intent(Main2Activity.this, Main3Activity.class);
                    if (sayac != 0) {
                        if (sayı == parseInt(editTextGirdi.getText().toString())) {
                            a.putExtra("sonuc", true);
                            startActivity(a);
                            finish();
                        } else if (sayı > parseInt(editTextGirdi.getText().toString())) {
                            textViewYardim.setText("YÜKSELT");
                        } else
                            textViewYardim.setText("AZALT");
                    } else {
                        a.putExtra("sonuc", false);
                        startActivity(a);
                        finish();
                    }
                    editTextGirdi.setText("");
                }
                else
                    Toast.makeText(getApplicationContext(),"Sayı Giriniz",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
