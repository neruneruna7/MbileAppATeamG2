package jp.ac.meijou.android.mobileappateamg2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.datastore.preferences.core.PreferencesKeys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;
import java.util.logging.Logger;

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

        binding.ptText.setText("10000");

        var wakeUpHourPrefKey = PreferencesKeys.intKey("WakeUpHour");
        var wakeUpMinutePrefKey = PreferencesKeys.intKey("WakeUpMinute");

        int wakeUpHour = 0;
        int wakeUpMinute = 0;

        int test = dataStore.get(wakeUpHourPrefKey).orElse(0);


        // 起きたボタン 現在時刻と設定時刻の差を計算し，次の画面に渡す.
        binding.wakeUpButton.setOnClickListener(view -> {
            var cal = Calendar.getInstance();

            int nowHour = cal.get(Calendar.HOUR);
            int nowMinute = cal.get(Calendar.MINUTE);

            int hour = wakeUpHour - nowHour;
            int minute = wakeUpMinute - nowMinute;

            int late_minute = minute + (hour * 60);

            Log.d("late_minute", String.valueOf(late_minute));

            var intent = new Intent(this, GetupLate.class);
            intent.putExtra("late_minute", late_minute);
            startActivity(intent);

        });

        binding.settingButton.setOnClickListener(view -> {

        });

        binding.settingButton.setOnClickListener(view -> {
            // 片貝くん担当の設定画面に遷移する
            var intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
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