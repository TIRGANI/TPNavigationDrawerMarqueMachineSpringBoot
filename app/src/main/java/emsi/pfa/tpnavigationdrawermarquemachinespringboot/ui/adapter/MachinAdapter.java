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

public class MachinAdapter extends ArrayAdapter<Machine> {
    public MachinAdapter(Context context, ArrayList<Machine> machines)
    {
        super(context, R.layout.itemmachine,machines);

    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Machine machine = getItem(position);
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itemmachine,parent,false);
        }
        TextView dateAchat = convertView.findViewById(R.id.dateAchat);
        TextView prix = convertView.findViewById(R.id.prix);
        TextView reference = convertView.findViewById(R.id.reference);
        TextView marqueid = convertView.findViewById(R.id.marque_id);

        dateAchat.setText(machine.getDate()+"");
        prix.setText(machine.getPrix()+"");
        reference.setText(machine.getReference());
        marqueid.setText(machine.getMarque().getCode());

        return convertView;
    }
}
