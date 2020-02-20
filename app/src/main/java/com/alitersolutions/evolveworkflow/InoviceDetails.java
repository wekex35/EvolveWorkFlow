package com.alitersolutions.evolveworkflow;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.alitersolutions.evolveworkflow.model.InoviceDetailsModels;
import com.alitersolutions.evolveworkflow.utils.AppUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static android.widget.Toast.LENGTH_SHORT;

public class InoviceDetails extends AppCompatActivity {
    int arraySize;
    LinearLayout detailsHolder;
    int index = 0;
    List<InoviceDetailsModels> inoviceDetailsModels;
    String inovoiceId;
    int invoiceno;


    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_inovice_details);
        setTitle(R.string.invoice_details);
        invoiceno = getIntent().getIntExtra("invoiceno",0);
        initViews();
    }

    private void initViews() {
        this.detailsHolder = (LinearLayout) findViewById(R.id.detailsHolder);
        loadItems();
    }

    private void loadItems() {
        this.inoviceDetailsModels = (List) new Gson().fromJson(AppUtils.inputStreamToString(getResources().openRawResource(R.raw.csvjson)), new TypeToken<List<InoviceDetailsModels>>() {
        }.getType());
        this.arraySize = this.inoviceDetailsModels.size();
        DataList((InoviceDetailsModels) this.inoviceDetailsModels.get(invoiceno));
    }

    private void DataList(InoviceDetailsModels inoviceDetails1) {
        this.detailsHolder.removeAllViews();
        addInvoiceData(inoviceDetails1);
        addHistoryData(inoviceDetails1);
        this.index++;
    }

    private void addInvoiceData(InoviceDetailsModels inoviceDetails1) {
        View view = getLayoutInflater().inflate(R.layout.card_items_holder, null, false);
        final TextView heading = (TextView) view.findViewById(R.id.heading);
        heading.setText(R.string.invoice_details);
        final LinearLayout itemHolder = (LinearLayout) view.findViewById(R.id.itemHolder);
        heading.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (itemHolder.getVisibility() == VISIBLE) {
                    itemHolder.setVisibility(GONE);
                    heading.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_up_black_24dp, 0);
                    return;
                }
                itemHolder.setVisibility(VISIBLE);
                heading.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down_black_24dp, 0);
            }
        });
        this.inovoiceId = inoviceDetails1.getInvoiceDocNo();
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice Details (");
        sb.append(this.inovoiceId);
        sb.append(")");
        setTitle(sb.toString());
        addDataToView(itemHolder, "Invoice Doc No", inoviceDetails1.getInvoiceDocNo());
        addDataToView(itemHolder, "Company Code", inoviceDetails1.getCompanyCode());
        addDataToView(itemHolder, "Invoice Amount", inoviceDetails1.getInvoiceAmount());
        addDataToView(itemHolder, "Currency", inoviceDetails1.getCurrency());
        addDataToView(itemHolder, "Expense Type", inoviceDetails1.getExpenseType());
        addDataToView(itemHolder, "Vendor Code", inoviceDetails1.getVendorCode());
        addDataToView(itemHolder, "Vendor Name", inoviceDetails1.getVendorName());
        addDataToView(itemHolder, "Reference ", inoviceDetails1.getREFERENCENBr());
        this.detailsHolder.addView(view);
    }

    private void addHistoryData(InoviceDetailsModels inoviceDetails1) {
        View view = getLayoutInflater().inflate(R.layout.card_items_holder, null, false);
        final TextView heading = (TextView) view.findViewById(R.id.heading);
        heading.setText(R.string.invoice_history);
        final LinearLayout itemHolder = (LinearLayout) view.findViewById(R.id.itemHolder);
        heading.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (itemHolder.getVisibility() == VISIBLE) {
                    itemHolder.setVisibility(GONE);
                    heading.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_up_black_24dp, 0);
                    return;
                }
                itemHolder.setVisibility(VISIBLE);
                heading.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down_black_24dp, 0);
            }
        });
        addDataToView(itemHolder, "Processed By ", inoviceDetails1.getProcessedBy());
        addDataToView(itemHolder, "Date ", inoviceDetails1.getDate());
        addDataToView(itemHolder, "Logged Action ", inoviceDetails1.getLoggedAction());
        addDataToView(itemHolder, "Comments ", inoviceDetails1.getComments());
        this.detailsHolder.addView(view);
    }

    private void addDataToView(LinearLayout itemHolder, String K, String V) {
        View view = getLayoutInflater().inflate(R.layout.two_item_list, null, false);
        TextView value = (TextView) view.findViewById(R.id.value);
        ((TextView) view.findViewById(R.id.key)).setText(K);
        value.setText(V);
        itemHolder.addView(view);
    }

    public void query(View view) {
        final Dialog dialog = new Dialog(this);
        View view1 = getLayoutInflater().inflate(R.layout.query, null, false);
        ((TextView) view1.findViewById(R.id.inoviceid)).setText(this.inovoiceId);
        EditText editText = (EditText) view1.findViewById(R.id.message);
        ((Button) view1.findViewById(R.id.send)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(InoviceDetails.this, "Query Sent ", LENGTH_SHORT).show();
            }
        });
        dialog.setContentView(view1);
        dialog.show();
    }

    public void ViewImage(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(getLayoutInflater().inflate(R.layout.image_view, null, false));
        dialog.show();
    }

    public void refer(View view) {
        startActivity(new Intent(this, ForwardActivity.class));
    }

    public void next(View view) {
        if (R.id.approve == view.getId()) {
            Toast.makeText(this, "", LENGTH_SHORT).show();
            Toast.makeText(this, "Approved", LENGTH_SHORT).show();
        } else if (R.id.reject == view.getId()) {
            Toast.makeText(this, "Rejected", LENGTH_SHORT).show();
        }
        int i = this.index;
        if (i < this.arraySize) {
            DataList((InoviceDetailsModels) this.inoviceDetailsModels.get(i));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.viewList :
                Intent intent = new Intent(this,InvoiceList.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|
                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return true;
            default: return super.onOptionsItemSelected(item);
        }

    }

}
