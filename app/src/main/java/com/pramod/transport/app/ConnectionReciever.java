package com.pramod.transport.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.snackbar.Snackbar;
import com.pramod.transport.R;
import com.pramod.transport.databinding.RecyclerRowBinding;

public class ConnectionReciever extends BroadcastReceiver {


    private Context mContext;
    private LinearLayout linearLayout;
    private @NonNull RecyclerRowBinding rowLayoutBinding;


    public ConnectionReciever(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public void onReceive(Context context, Intent intent) {

        if (isConnected(context)) {
            Toast.makeText(context, "Internet Is Connected", Toast.LENGTH_SHORT).show();


        } else {
           Toast.makeText(context, "Internet Is  not Connected", Toast.LENGTH_SHORT).show();


             //demo();
        }

    }



    public boolean isConnected(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }

    }

    private void demo() {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


       /* rowLayoutBinding = RecyclerRowBinding.inflate(inflater);

        builder.setView(rowLayoutBinding.getRoot());*/
        View view = inflater.inflate(R.layout.row_layout,null);
        Button button = view.findViewById(R.id.ok);
        builder.setView(view);
        final Dialog  dialog = builder.create();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
          dialog.show();
    }
}
