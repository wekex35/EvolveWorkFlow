package com.alitersolutions.evolveworkflow;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ForwardActivity extends AppCompatActivity {
    String TAG = "ForwardActivity";
    ListView listView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forward);
        this.listView = (ListView) findViewById(R.id.forwardlist);
        this.listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                TextView textView = (TextView) view;
                String sentTo = textView.getText().toString();
                String str = ForwardActivity.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onItemClick: ");
                sb.append(textView.getText().toString());
                Log.d(str, sb.toString());
                ForwardActivity forwardActivity = ForwardActivity.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Forwarded to ");
                sb2.append(sentTo);
                Toast.makeText(forwardActivity, sb2.toString(), 0).show();
                ForwardActivity.this.finish();
            }
        });
    }
}
