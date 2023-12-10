package jp.ac.meijou.android.mobileappateamg2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Optional;

import jp.ac.meijou.android.mobileappateamg2.databinding.ActivityGetupLateBinding;

public class GetupLate extends AppCompatActivity {

    private ActivityGetupLateBinding binding;

    private final ActivityResultLauncher<Intent> getActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                switch (result.getResultCode()) {
                    case RESULT_OK:
                        Optional.ofNullable(result.getData())
                                .map(data -> data.getStringExtra("ret"))
                                .map(text -> "Result: " + text);
                        break;
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetupLateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Optional.ofNullable(getIntent().getStringExtra("text"))
                .ifPresent(text -> binding.mainasu.setText(text));

        Intent get_intent = getIntent();

        // とりあえずの初期値に0
        int late_minute = get_intent.getIntExtra("late_minute", 0);

        binding.mainasu.setText(String.valueOf(late_minute));


        //PrefDataStore = PrefDataStore.getInstance(this);





        // 遷移する
        binding.backbutton.setOnClickListener(view -> {
            var intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}