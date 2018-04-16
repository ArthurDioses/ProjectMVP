package com.example.adiosesr.appmvpexample.home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adiosesr.appmvpexample.R;
import com.example.adiosesr.appmvpexample.active.ActiveFragment;
import com.example.adiosesr.appmvpexample.complete.CompleteFragment;
import com.example.adiosesr.appmvpexample.profile.ProfileFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    private HomePresenter presenter;

    @BindView(R.id.tlTabLayout)
    TabLayout tlTabLayout;

    @BindView(R.id.vpViewPager)
    ViewPager vpViewPager;

    private int[] tabIcons = {
            R.drawable.ic_active,
            R.drawable.ic_complete,
            R.drawable.ic_profile};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initActivity();
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        //default Implementation
    }

    @Override
    public Context context() {
        return this;
    }

    void initActivity() {
        presenter = new HomePresenter(this);
        presenter.start();
        setupViewPager(vpViewPager);
        tlTabLayout.setupWithViewPager(vpViewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tlTabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tlTabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tlTabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void setupViewPager(ViewPager vpViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ActiveFragment(), "Activo");
        adapter.addFragment(new CompleteFragment(), "Completo");
        adapter.addFragment(new ProfileFragment(), "Perfil");
        vpViewPager.setAdapter(adapter);
    }
}
