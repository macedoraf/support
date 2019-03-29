package rafael.macedo.starterpack;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import rafael.macedo.supportbase.BaseActivity;
import rafael.macedo.supportbase.util.OnRetryListener;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_loading_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
            }
        });

        findViewById(R.id.btn_retry_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRetryDialog(new OnRetryListener() {
                    @Override
                    public void onClickRetry() {
                        Toast.makeText(MainActivity.this, "Retry", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onClickDontRetry() {
                        Toast.makeText(MainActivity.this, "dont retry", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
