package jp.ac.meijou.android.mobileappateamg2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.datastore.preferences.core.PreferencesKeys;

import android.content.Intent;
import android.os.Bundle;

import java.util.prefs.Preferences;

import jp.ac.meijou.android.mobileappateamg2.databinding.ActivityBankAccountRegistrationBinding;

public class BankAccountRegistrationActivity extends AppCompatActivity {

    private ActivityBankAccountRegistrationBinding binding;
    private PrefDataStore prefDataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBankAccountRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.registrationButton.setOnClickListener(view -> {
            var prefkey = PreferencesKeys.stringKey("CreditNumber");
            prefDataStore.set(prefkey, "CreditNumber");

            var intent = new Intent(this, MainActivity.class);
            intent.putExtra("CreditNumber", binding.enterAccountNumberText.getText().toString());
            startActivity(intent);

            finish();
        });
    }
}