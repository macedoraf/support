package rafael.macedo.supportbase;

import android.support.v7.app.AppCompatActivity;

import rafael.macedo.supportbase.util.Dialog;
import rafael.macedo.supportbase.util.OnRetryListener;

public abstract class BaseActivity extends AppCompatActivity {

    protected String TAG = this.getClass().getName();

    protected void showLoading(){
        Dialog.Companion.showLoadingDialog(this);
    }
    protected void hideLoading(){
        Dialog.Companion.showLoadingDialog(this);
    }
    protected void showRetryDialog(OnRetryListener onRetryListener){
        Dialog.Companion.showRetryDialog(this,onRetryListener);

    }


}
