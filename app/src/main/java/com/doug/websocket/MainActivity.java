package com.doug.websocket;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSONObject;
import com.doug.lib.AbsWebSocketActivity;
import com.doug.lib.ErrorResponse;
import com.doug.lib.Response;


public class MainActivity extends AbsWebSocketActivity {

    /**
     * 假设这是登陆的接口Path
     */
    private static final String LOGIN_PATH = "Login";

    private EditText etAccount;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        etAccount = (EditText) findViewById(R.id.et_account);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString();
                String password = etPassword.getText().toString();
                if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
                    UiUtil.showToast(MainActivity.this, "输入不能为空");
                    return;
                }
                login(account, password);
            }
        });
    }

    private void login(String account, String password) {
        JSONObject params = new JSONObject();
        JSONObject command = new JSONObject();
        JSONObject parameters = new JSONObject();

        command.put("path", LOGIN_PATH);

        parameters.put("username", account);
        parameters.put("password", password);

        params.put("command", command);
        params.put("parameters", parameters);
        sendText(params.toJSONString());
    }

    @Override
    public void onMessageResponse(Response message) {
        UiUtil.showToast(MainActivity.this, "登陆成功: " + ((CommonResponse) message).getResponseEntity().getMessage());
    }

    @Override
    public void onSendMessageError(ErrorResponse error) {
        UiUtil.showToast(MainActivity.this, error.getDescription());
    }
}
