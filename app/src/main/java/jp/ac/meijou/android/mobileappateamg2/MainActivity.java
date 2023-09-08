package jp.ac.meijou.android.mobileappateamg2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.datastore.preferences.core.PreferencesKeys;

import android.os.Bundle;

import java.util.Calendar;

import jp.ac.meijou.android.mobileappateamg2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private PrefDataStore dataStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataStore = PrefDataStore.getInstance(getApplicationContext());

        binding.ptText.setText("0");



        binding.wakeUpButton.setOnClickListener(view -> {
            var cal = Calendar.getInstance();

            int nowHour = cal.get(Calendar.HOUR);
            int nowMinute = cal.get(Calendar.MINUTE);

        });

        binding.settingButton.setOnClickListener(view -> {

        });
        //futagami
        //nishimu
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        // kvストアからポイントの値を読み出す
        var prefKey = PreferencesKeys.stringKey("RemainPoints");
        dataStore.get(prefKey)
                .ifPresent(remainPoints -> binding.ptText.setText(remainPoints));
    }

    //katakai
}