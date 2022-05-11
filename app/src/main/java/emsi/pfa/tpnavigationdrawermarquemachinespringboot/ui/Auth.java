package emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.List;

import emsi.pfa.tpnavigationdrawermarquemachinespringboot.MainActivity;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.R;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.beans.User;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.service.UserService;
import emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.session.SessionManagement;

public class Auth extends AppCompatActivity {
    Button b1, b2;
    EditText ed1, ed2;
    String insertUrllo = "http://10.0.2.2:8090/users/all";

    RequestQueue requestQueue;

    TextView tx1;
    SessionManagement sessionManagement;
    int counter = 3;
    private List<User> users;
    private UserService service;


    @Override
    protected void onStart() {

        super.onStart();
        //check if user in logged in
        //if user is logged in move to main activity
        sessionManagement = new SessionManagement(Auth.this);
        int id = sessionManagement.getSession();

        if (id != -1) {
            moveToMainActivity();
        } else {
            connection();
        }

    }

    private void moveToMainActivity() {
        Intent intent = new Intent(Auth.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void connection() {
        if (service.findByName(ed1.getText().toString(), ed2.getText().toString())) {
            //session
            User user = service.findByNamee(ed1.getText().toString(), ed2.getText().toString());
            //   Log.d("userssssssssssss",user.getRole().getNome());
            sessionManagement.saveSessione(user);
            moveToMainActivity();
        } else {
            Toast.makeText(Auth.this, "Wrong"
                    , Toast.LENGTH_SHORT).show();

            //   tx1.setVisibility(View.VISIBLE);
            // tx1.setBackgroundColor(Color.RED);
            counter--;
            // tx1.setText(Integer.toString(counter));

            if (counter == 0) {
                b1.setEnabled(false);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        b1 = (Button) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);

        b2 = (Button) findViewById(R.id.button2);
        //tx1 = (TextView)findViewById(R.id.textView3);
        //   tx1.setVisibility(View.GONE);
        users = new ArrayList<>();
        service = new UserService();

        sessionManagement = new SessionManagement(Auth.this);

        getdatauser();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                connection();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }




    private void getdatauser() {

        //***************************user**********************************
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.GET,
                insertUrllo, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("********************", "user");
                Type type = new TypeToken<Collection<User>>() {
                }.getType();
                Collection<User> user = new Gson().fromJson(response, type);

                for (User e : user) {
                    User s = new User(e.getUser_id(),  e.getPassword() + "", e.getUsername() + "");
                    Log.d("user",s.getUsername()+"");
                    service.create(s);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(request);

    }

}