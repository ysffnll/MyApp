package bilkent.edu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    private ImageView imageViewSonuc;
    private TextView textViewSonuc;
    private Button buttonTekrar;
    private boolean sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imageViewSonuc = findViewById(R.id.imageViewSonuc);
        textViewSonuc = findViewById(R.id.textViewSonuc);
        buttonTekrar = findViewById(R.id.buttonTekrar);
        sonuc = getIntent().getBooleanExtra("sonuc",false);
        if(sonuc)
        {
            imageViewSonuc.setImageResource(R.drawable.mutlu);
            textViewSonuc.setText("KAZANDINIZ");
        }else{
            imageViewSonuc.setImageResource(R.drawable.uzgun);
            textViewSonuc.setText("KAYBETTİNİZ");
        }
        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(a);
                finish();
            }
        });
    }
}
