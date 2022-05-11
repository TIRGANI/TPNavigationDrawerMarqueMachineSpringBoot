package emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.marque;

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

import emsi.pfa.tpnavigationdrawermarquemachinespringboot.databinding.FragmentMarqueBinding;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.adapter.MachinAdapter;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.adapter.MarqueAdapter;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.Machine;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.Marque;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.service.MachineService;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.service.MarqueService;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.session.SessionManagement;

public class MarqueFragement extends Fragment {
    private FragmentMarqueBinding binding;
    String insertUrllo = "http://10.0.2.2:8090/marques/all";
    RequestQueue requestQueue;
    SessionManagement sessionManagement;
    private ArrayList<Marque> marq = new ArrayList<>();
    private MarqueService service;


    @Override
    public void onStart() {
        marq.clear();
        getdataMarque();
        super.onStart();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentMarqueBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textSlideshow;
        //textView.setText("Marque");
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void getdataMarque() {

        //***************************user**********************************
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.GET,
                insertUrllo, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("********************", "marques");
                Type type = new TypeToken<Collection<Marque>>() {
                }.getType();
                Collection<Marque> marques = new Gson().fromJson(response, type);

                for (Marque e : marques) {
                    //   Machine s = new Machine(e.getId(),e.getPrix(),e.getReference(),e.getMarque());
                    Log.d("machin : ", e.getId() + " | " + e.getCode() + " | " + e.getLibelle() );
                    marq.add(e);
                }
                MarqueAdapter marqueAdapter = new MarqueAdapter(getActivity().getApplicationContext(), marq);
                binding.listmarque.setAdapter(marqueAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(request);

    }
}
