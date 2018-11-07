package net.iqbalfauzan.myindi;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import net.iqbalfauzan.myindi.fragment.FragmentAccount;
import net.iqbalfauzan.myindi.fragment.FragmentCustomerServis;
import net.iqbalfauzan.myindi.fragment.FragmentHome;
import net.iqbalfauzan.myindi.fragment.FragmentNotif;
import net.iqbalfauzan.myindi.fragment.FragmentScanner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottom_navigation)
    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        BottomNavigationViewHelper.disableShiftMode(navigationView);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()){
                    case R.id.action_home:
                        selectedFragment = FragmentHome.newInstance();
                        break;
                    case R.id.action_cs:
                        selectedFragment = FragmentCustomerServis.newInstance();
                        break;
                    case R.id.action_scanner:
                        selectedFragment = FragmentScanner.newInstance();
                        break;
                    case R.id.action_account:
                        selectedFragment = FragmentAccount.newInstance();
                        break;
                    case R.id.action_notif:
                        selectedFragment = FragmentNotif.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_home, selectedFragment);
                transaction.commit();
                return true;
            }
        });
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_home, FragmentHome.newInstance());
        transaction.commit();
    }
}
