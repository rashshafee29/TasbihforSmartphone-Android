package com.example.rashidalshafee.tasbihforsmartphone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private int tasbihCn = 0;
    Button btn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    HashMap<Date, String> valMp = new HashMap<Date, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasbihCn ++;
                btn.setText(Integer.toString(tasbihCn));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tasbihmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.reset:
                if(tasbihCn>0)
                    saveData();
                tasbihCn = 0;
                btn.setText(Integer.toString(tasbihCn));
                break;
            case R.id.history:
                Intent intent = new Intent(MainActivity.this,LoadData.class);
                startActivity(intent);
                break;
            case R.id.about:
                openDialog();
                break;
        }
        return true;
    }

    private void saveData() {
        Date currenttime = Calendar.getInstance().getTime();
        sharedPreferences = this.getSharedPreferences("Tasbeeh",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(String.valueOf(currenttime),Integer.toString(tasbihCn));
        editor.commit();
    }

    private void openDialog() {
        TasbihDialog tasbihDialog = new TasbihDialog();
        tasbihDialog.show(getSupportFragmentManager(),"Tasbeeh dialog");
    }
}
