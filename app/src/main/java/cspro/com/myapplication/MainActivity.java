package cspro.com.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_READ_CONTACT = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Untuk cek baca list kontak
        int checkContact = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);

        if (checkContact != PackageManager.PERMISSION_GRANTED) {
            //tampilkan pertanyaan izin aplikasi

            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.READ_CONTACTS},
                    REQUEST_CODE_READ_CONTACT);
        } else {
            // yeayy your apps persmission granted
            Toast.makeText(this, "Aplikasi sudah dizinkan", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_READ_CONTACT) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, getString(R.string.pesan_ijin_allow), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Waduhhh.. kok gak dijinkan sih", Toast.LENGTH_LONG).show();
            }
        }
    }
}
