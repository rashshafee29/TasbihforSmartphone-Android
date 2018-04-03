package com.example.rashidalshafee.tasbihforsmartphone;

import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LoadData extends AppCompatActivity {
    //HashMap<Date, String> valMp = new HashMap<Date, String>();
    ArrayList<Map<String,String > > mylist = new ArrayList<Map<String,String >>();
    TextView textView;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_data);
        final MainActivity mainActivity = new MainActivity();
        mainActivity.sharedPreferences = this.getSharedPreferences("Tasbeeh",MODE_PRIVATE);
        mainActivity.editor = mainActivity.sharedPreferences.edit();
        Map valMp = mainActivity.sharedPreferences.getAll();
        mylist.add(valMp);
        textView = (TextView)findViewById(R.id.txt);
        textView.setMovementMethod(new ScrollingMovementMethod());
        Map<String, String> map = new TreeMap<String, String>(valMp);
        Set keySet = map.entrySet();
        Iterator iterator = (Iterator) keySet.iterator();
        while (iterator.hasNext()){
            Map.Entry me2 = (Map.Entry)iterator.next();
            String key = (String)me2.getKey();
            String val = (String)me2.getValue();
            textView.append(key+ ": " +val+"\n");
        }
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.editor.clear();
                mainActivity.editor.commit();
                textView.setText("Deleted all Data");
            }
        });
    }
}
