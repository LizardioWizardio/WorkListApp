package ru.artemfirstov.worklist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import ru.artemfirstov.worklist.databinding.ContentMainBinding;
import ru.artemfirstov.worklist.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityViewModel viewModel = new MainActivityViewModel(this);

        ContentMainBinding contentMainBinding = DataBindingUtil.setContentView(this, R.layout.content_main);
        contentMainBinding.setViewModel(viewModel);

        viewModel.onCreate();
    }
}
