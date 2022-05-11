package emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.machine;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

import emsi.pfa.tpnavigationdrawermarquemachinespringboot.databinding.FragmentMachineBinding;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.adapter.MachinAdapter;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.Machine;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.detaille.MachineDetaille;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.service.MachineService;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.session.SessionManagement;

public class MachineFragement extends Fragment {
    private FragmentMachineBinding binding;

    String insertUrllo = "http://10.0.2.2:8090/machines/all";
    RequestQueue requestQueue;
    SessionManagement sessionManagement;

    private ArrayList<Machine> machi = new ArrayList<>();
    private MachineService service;

    @Override
    public void onStart() {
        machi.clear();
        getdatMachines();
        super.onStart();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentMachineBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMachine;

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getdatMachines() {

        //***************************user**********************************
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.GET,
                insertUrllo, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("********************", "machines");
                Type type = new TypeToken<Collection<Machine>>() {
                }.getType();
                Collection<Machine> machines = new Gson().fromJson(response, type);

                for (Machine e : machines) {
                    //   Machine s = new Machine(e.getId(),e.getPrix(),e.getReference(),e.getMarque());
                    Log.d("machin : ", e.getId() + " | " + e.getPrix() + " | " + e.getReference() + " | marque : " + e.getMarque().getId() + " | " + e.getMarque().getCode() + " | " + e.getMarque().getLibelle());
                    machi.add(e);
                }
                MachinAdapter machinAdapter = new MachinAdapter(getActivity().getApplicationContext(), machi);
                binding.listmachine.setAdapter(machinAdapter);
                binding.listmachine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent intent = new Intent(getActivity().getApplicationContext(), MachineDetaille.class);
                        intent.putExtra("date",machi.get(i).getDate());
                        intent.putExtra("prix",machi.get(i).getPrix());
                        intent.putExtra("reference",machi.get(i).getReference());
                        intent.putExtra("marque",machi.get(i).getMarque().getCode());
                        startActivity(intent);
                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(request);

    }
}
