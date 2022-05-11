package emsi.pfa.tpnavigationdrawermarquemachinespringboot.ui.detaille;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import emsi.pfa.tpnavigationdrawermarquemachinespringboot.databinding.DetailmachineBinding;

public class MachineDetaille extends AppCompatActivity {
    private DetailmachineBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DetailmachineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();
        if(intent != null)
        {
            binding.dmdate.setText( intent.getStringExtra("date") + "");
            binding.dmmarque.setText( intent.getStringExtra("prix") + "");
            binding.dmprix.setText( intent.getStringExtra("reference") + "");
            binding.dmreference.setText( intent.getStringExtra("marque") + "");
        }


    }
}
