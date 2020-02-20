package com.alitersolutions.evolveworkflow;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alitersolutions.evolveworkflow.model.InoviceDetailsModels;

import java.util.List;

class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.InoListView> {
    Context context;
    List<InoviceDetailsModels> inoviceList;
    public InvoiceAdapter(Context context, List<InoviceDetailsModels> inoviceList) {
        this.context = context;
        this.inoviceList = inoviceList;
    }

    @NonNull
    @Override
    public InoListView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.two_item_list,parent,false);
        return new InoListView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InoListView holder, int position) {
        holder.setData(inoviceList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return inoviceList.size();
    }

    public class InoListView extends RecyclerView.ViewHolder {
        TextView invoice,venderName;
        LinearLayout parent;
        public InoListView(@NonNull View itemView) {
            super(itemView);
            invoice = itemView.findViewById(R.id.key);
            venderName = itemView.findViewById(R.id.value);
            parent = itemView.findViewById(R.id.parent);
        }

        public void setData(InoviceDetailsModels inoviceDetailsModels, final int position) {
            invoice.setText(inoviceDetailsModels.getInvoiceDocNo());
            venderName.setText(inoviceDetailsModels.getVendorName());
            parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,InoviceDetails.class);
                    intent.putExtra("invoiceno",position);

                    context.startActivity(intent);
                }
            });
        }
    }
}
