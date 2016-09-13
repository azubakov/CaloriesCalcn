package azubakov.edu.caloriescalc.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sa90.materialarcmenu.ArcMenu;
import com.sa90.materialarcmenu.StateChangeListener;

import azubakov.edu.caloriescalc.R;

public class DairyActivity extends AppCompatActivity {

    ArcMenu arcMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        arcMenu = (ArcMenu) findViewById(R.id.arcMenu);
        arcMenu.setRadius(getResources().getDimension(R.dimen.radius));
        arcMenu.setStateChangeListener(new StateChangeListener() {
            @Override
            public void onMenuOpened() {

            }

            @Override
            public void onMenuClosed() {

            }
        });



    }

    private View.OnClickListener subMenuClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            arcMenu.toggleMenu();
        }
    };

}
