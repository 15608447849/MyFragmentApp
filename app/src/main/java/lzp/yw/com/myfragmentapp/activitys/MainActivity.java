package lzp.yw.com.myfragmentapp.activitys;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import lzp.yw.com.myfragmentapp.R;
import lzp.yw.com.myfragmentapp.fragments.Fragment1;
import lzp.yw.com.myfragmentapp.fragments.Fragment2;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener,Fragment2.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.i("","MainActivity_onFragmentInteraction() " + uri);
    }
    public void dyAddFragment(View view){
        createDyFragment();
    }
    /**
     * 动态创建fragment
     */
    private void createDyFragment(){
        startActivity(new Intent(this,Main2Activity.class));
    }

    /**
     * fagment 实战
     */
    public void fagmentApplication(View v){
        startActivity(new Intent(this,Main3Activity.class));
    }






}
