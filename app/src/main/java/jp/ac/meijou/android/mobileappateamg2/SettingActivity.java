package jp.ac.meijou.android.mobileappateamg2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.datastore.preferences.core.PreferencesKeys;

import android.content.Intent;
import android.os.Bundle;

import jp.ac.meijou.android.mobileappateamg2.databinding.ActivitySettingBinding;

public class SettingActivity extends AppCompatActivity {

    private ActivitySettingBinding binding;
    private PrefDataStore prefDataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefDataStore = prefDataStore.getInstance(this);

        //binding.changeButton.setOnClickListener(view ->{
           // var intent = new Intent(this, SubActivity.class);
           // startActivity(intent);
        //});

        binding.decideButton.setOnClickListener(view ->{

            var hour = binding.hour.getText().toString();
            binding.hour.setText(hour);

            var minute = binding.hour.getText().toString();
            binding.hour.setText(minute);

            prefDataStore = PrefDataStore.getInstance(getApplicationContext());

            var wakeUpHourPrefKey = PreferencesKeys.intKey("WakeUpHour");
            prefDataStore.set(wakeUpHourPrefKey, 10);

            var wakeUpMinutePrefKey = PreferencesKeys.intKey("WakeUpMinute");
            prefDataStore.set(wakeUpMinutePrefKey, 10);

            finish();

        });
    }
}