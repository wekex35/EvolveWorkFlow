package com.alitersolutions.evolveworkflow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.alitersolutions.evolveworkflow.model.InoviceDetailsModels;
import com.alitersolutions.evolveworkflow.utils.AppUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class InvoiceList extends AppCompatActivity {
    RecyclerView inoviceRecyclerList;
    int arraySize;
    LinearLayout detailsHolder;
    int index = 0;
    List<InoviceDetailsModels> inoviceDetailsModels;
    String inovoiceId;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_list);
        setTitle("Invoice List");
        inoviceRecyclerList = findViewById(R.id.invoiceRecyclerList);
        loadItems();
    }

    private void loadItems() {
        this.inoviceDetailsModels = (List) new Gson().fromJson(AppUtils.inputStreamToString(getResources().openRawResource(R.raw.csvjson)), new TypeToken<List<InoviceDetailsModels>>() {
        }.getType());
        this.arraySize = this.inoviceDetailsModels.size();
        InvoiceAdapter invoiceAdapter = new InvoiceAdapter(this,inoviceDetailsModels);
        inoviceRecyclerList.setHasFixedSize(true);
        inoviceRecyclerList.setLayoutManager(new LinearLayoutManager(this));
        inoviceRecyclerList.setAdapter(invoiceAdapter);
    }
}
