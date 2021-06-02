package sg.edu.rp.c346.id20047778.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //translate #1
    TextView tvTranslatedText,tvTranslatedText2,tvTranslatedText3;
    //click to navigate #2
    String wordClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //translate #1
        tvTranslatedText = findViewById(R.id.tvTranslatedTextView);
        tvTranslatedText2 = findViewById(R.id.tvTranslatedTextView2);
        tvTranslatedText3 = findViewById(R.id.tvTranslatedTextView3);


        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);
        registerForContextMenu(tvTranslatedText3);
    }

    @Override //translate #1
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override //translate #1
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.englishSelection){
            tvTranslatedText.setText("DBS");
            tvTranslatedText2.setText("OCBC");
            tvTranslatedText3.setText("UOB");

        } else if(item.getItemId() == R.id.chineseSelection){
            tvTranslatedText.setText("星展银行");
            tvTranslatedText2.setText("华侨银行");
            tvTranslatedText3.setText("大华银行");
        }
        return super.onOptionsItemSelected(item);
    }
    //click to select either website or call

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");

        if (v == tvTranslatedText) {
            wordClicked = "@string/dbs";
        } else if (v == tvTranslatedText2) {
            wordClicked = "@string/ocbc";
        } else if (v == tvTranslatedText3) {
            wordClicked = "@string/uob";
        }
    }

    @Override
        public boolean onContextItemSelected(@NonNull MenuItem item) {
            if (item.getItemId() == 0) {
                Toast.makeText(MainActivity.this,"Website selected",Toast.LENGTH_LONG).show();
            return true;
            }
            return super.onContextItemSelected(item);




}