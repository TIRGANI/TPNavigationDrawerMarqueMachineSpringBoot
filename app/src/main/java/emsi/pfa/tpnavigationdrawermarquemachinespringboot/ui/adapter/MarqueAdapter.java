package emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import emsi.pfa.tpnavigationdrawermarquemachinespringboot.R;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.Machine;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.Marque;

public class MarqueAdapter extends ArrayAdapter<Marque> {
    public MarqueAdapter(Context context, ArrayList<Marque> marques)
    {
        super(context, R.layout.itemmarque,marques);

    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Marque marque = getItem(position);
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itemmarque,parent,false);
        }
        TextView dateAchat = convertView.findViewById(R.id.code);
        TextView prix = convertView.findViewById(R.id.libelle);

        dateAchat.setText(marque.getCode()+"");
        prix.setText(marque.getLibelle()+"");


        return convertView;
    }
}
