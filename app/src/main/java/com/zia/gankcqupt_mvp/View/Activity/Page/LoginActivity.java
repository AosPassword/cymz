package com.zia.gankcqupt_mvp.View.Activity.Page;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zia.gankcqupt_mvp.Presenter.Activity.Interface.ILoginPresenter;
import com.zia.gankcqupt_mvp.Presenter.Activity.Main.LoginPresenter;
import com.zia.gankcqupt_mvp.R;
import com.zia.gankcqupt_mvp.Util.ToastUtil;
import com.zia.gankcqupt_mvp.View.Activity.Interface.ILoginActivity;

public class LoginActivity extends AppCompatActivity implements ILoginActivity {

    private TextView skip,register,login;
    public static TextInputLayout user,psw;
    private ILoginPresenter presenter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this);
        findWidgets();
        setClick();
    }

    private void setClick() {
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.gotoMainPage();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.gotoRegisterPage();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearError();
                if(getUsername().isEmpty()){
                    setUsernameFormatError();
                    return;
                }
                if(getPassword().isEmpty()){
                    setPasswordError();
                    return;
                }
                presenter.login(getUsername(),getPassword());
            }
        });
    }

    private void findWidgets() {
        skip = (TextView)findViewById(R.id.login_skip);
        register = (TextView)findViewById(R.id.login_register);
        login = (TextView)findViewById(R.id.login_login);
        user = (TextInputLayout) findViewById(R.id.login_username);
        psw = (TextInputLayout) findViewById(R.id.login_password);
    }

    @Override
    public String getUsername() {
        if(user.getEditText() == null) return "";
        return user.getEditText().getText().toString();
    }

    @Override
    public String getPassword() {
        if(psw.getEditText() == null) return "";
        return psw.getEditText().getText().toString();
    }

    @Override
    public void showDialog() {
        if(dialog == null) dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 设置进度条的形式为圆形转动的进度条
        dialog.setCancelable(true);// 设置是否可以通过点击Back键取消
        dialog.setCanceledOnTouchOutside(true);// 设置在点击Dialog外是否取消Dialog进度条
        dialog.setTitle("正在登录");
        dialog.setMessage("稍等");
        dialog.show();
    }

    @Override
    public void hideDialog() {
        if(dialog == null) return;
        dialog.hide();
    }

    @Override
    public void toast(String msg) {
        ToastUtil.showToast(this,msg);
    }


    @Override
    public void setUsernameError() {
        user.setError("用户名不能为空");
    }

    @Override
    public void setPasswordError() {
        psw.setError("密码错误");
    }

    @Override
    public void setUsernameFormatError() {
        user.setError("用户名不能为空");
    }

    @Override
    public void clearError() {
        user.setErrorEnabled(false);
        psw.setErrorEnabled(false);
    }
}
