package lzp.yw.com.myfragmentapp.activitys;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;

import lzp.yw.com.myfragmentapp.R;
import lzp.yw.com.myfragmentapp.fragments.Fragment1;
import lzp.yw.com.myfragmentapp.fragments.Fragment2;

public class Main2Activity extends Activity implements Fragment1.OnFragmentInteractionListener,Fragment2.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    private void init() {

        Display display = getWindowManager().getDefaultDisplay();
        Fragment fragment = null;
        if (display.getWidth() > display.getHeight()) {
            fragment = new Fragment1();

        } else {
            fragment = new Fragment2();
        }
        FragmentManager fm =  getFragmentManager();
        fm.beginTransaction().replace(R.id.main_layout, fragment).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
