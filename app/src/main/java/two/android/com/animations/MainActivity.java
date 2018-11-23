package two.android.com.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button btnRestart;
    ArrayList<Integer> resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        btnRestart = findViewById(R.id.BTN_restart);
        resources = new ArrayList<>();
        resources.add(R.anim.blink);
        resources.add(R.anim.bounce);
        resources.add(R.anim.fade_in);
        resources.add(R.anim.fade_out);
        resources.add(R.anim.flip);
        resources.add(R.anim.rotate);
        resources.add(R.anim.sequential);
        resources.add(R.anim.slide_down);
        resources.add(R.anim.slide_up);
        resources.add(R.anim.together);
        resources.add(R.anim.translate);
        resources.add(R.anim.zoom_in);
        resources.add(R.anim.zoom_out);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.clearAnimation();
                Animation a = AnimationUtils.loadAnimation(MainActivity.this,getRandomAnim());
                button.startAnimation(a);
            }
        });
    }

    public int getRandomAnim(){
        Random random = new Random();
        int i = random.nextInt(14);

        return resources.get(i);
    }

    public void restart(View v){
        button.clearAnimation();
        recreate();
    }
}
