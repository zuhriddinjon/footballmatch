package uz.instat.footballmatch.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import uz.instat.footballmatch.R;
import uz.instat.footballmatch.ui.match.MatchInfoFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            MatchInfoFragment fragment = new MatchInfoFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

    }
}