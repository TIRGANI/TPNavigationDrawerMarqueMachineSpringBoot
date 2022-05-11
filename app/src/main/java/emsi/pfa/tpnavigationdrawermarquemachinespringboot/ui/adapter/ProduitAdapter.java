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
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.Marque;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.Produit;

public class ProduitAdapter extends ArrayAdapter<Produit> {
    public ProduitAdapter(Context context, ArrayList<Produit> produits)
    {
        super(context, R.layout.itemproduit,produits);

    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Produit produit = getItem(position);
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itemproduit,parent,false);
        }
        TextView code = convertView.findViewById(R.id.pcode);
        TextView nom = convertView.findViewById(R.id.pnom);
        TextView dateAchat = convertView.findViewById(R.id.pdate);
        TextView prix = convertView.findViewById(R.id.pprix);

        code.setText(produit.getCode()+"");
        nom.setText(produit.getNom()+"");

        dateAchat.setText(produit.getDate()+"");
        prix.setText(produit.getPrix()+"");


        return convertView;
    }
}
