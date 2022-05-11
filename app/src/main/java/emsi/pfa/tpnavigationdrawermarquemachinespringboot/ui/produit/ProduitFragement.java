package emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.produit;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import emsi.pfa.tpnavigationdrawermarquemachinespringboot.databinding.FragmentProduitBinding;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.adapter.MarqueAdapter;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.adapter.ProduitAdapter;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.Marque;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.Produit;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.service.MarqueService;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.service.ProduitService;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.session.SessionManagement;

public class ProduitFragement extends Fragment {
    private FragmentProduitBinding binding;
    String insertUrllo = "http://10.0.2.2:8090/produits/all";
    RequestQueue requestQueue;
    SessionManagement sessionManagement;
    private ArrayList<Produit> prod = new ArrayList<>();
    private ProduitService service;
    @Override
    public void onStart() {
        prod.clear();
        getdataProduit();
        super.onStart();
    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentProduitBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

      //  final TextView textView = binding.textGallery;
        //textView.setText("Produits");
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void getdataProduit() {
        //***************************user**********************************
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.GET,
                insertUrllo, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("********************", "produits");
                Type type = new TypeToken<Collection<Produit>>() {
                }.getType();
                Collection<Produit> produits = new Gson().fromJson(response, type);

                for (Produit e : produits) {
                    //   Machine s = new Machine(e.getId(),e.getPrix(),e.getReference(),e.getMarque());
                    Log.d("machin : ", e.getId() + " | " + e.getCode() + " | " + e.getDate() );
                    prod.add(e);
                }
                ProduitAdapter marqueAdapter = new ProduitAdapter(getActivity().getApplicationContext(), prod);
                binding.listproduit.setAdapter(marqueAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(request);
    }
}
