package fr.android.androidexercises;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

public class WaitService extends IntentService {

    public WaitService(){
        super(WaitService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try{
            wait(5000);
        }
        catch(Exception ignored){

        }

        Toast.makeText(this, "It's finish", Toast.LENGTH_SHORT).show();

    }
}
