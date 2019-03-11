package de.proneucon.mykamerademo;
/**
 * KAMERA
 * Nutzen der bereits vorhandenen Dienste
 * -> benötigt ggf. spezielle Berechtigungen -> User wird gefragt
 * -> legt die Daten wie bei anderen Apps in die selben Ordner ab
 *
 * <p>
 *
 * MediaStore: (als Intent verwendbar)
 * -> ermöglicht Zugriff auf die vorhandenen Medien
 * -> Verwaltung der MediaSpeicher-Applikation zur Medien-/Datenspeicherung
 * -> hier können Kamera und Video
 * INTENT_ACTION_STILL_IMAGE_CAMERA -> greift auf die KAMERA-Funktion zu
 * INTENT_ACTION_VIDEO_CAMERA -> greift auf die VIDEO-Funktion zu
 */

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //MEMBER
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        //welcher BTN wurde ausgewählt:
        switch (view.getId()) {
            case R.id.btn_foto:
                intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA); //KAMERA
                break;

            case R.id.btn_video:
                intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA); //VIDEO
                break;

            default:
                return;
        }

        //Test ob Intent leer ist
        if (intent != null) {
            //einfach intent aufbauen und abschicken
            startActivity(intent);
        }
    }
}
