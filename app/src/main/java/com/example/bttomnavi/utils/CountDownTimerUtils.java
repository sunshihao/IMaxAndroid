package com.example.bttomnavi.utils;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/**
 * @data on 20210208
 * @auther sssh
 * @describe 倒计时工具类
 */
public class CountDownTimerUtils extends CountDownTimer {
    private TextView mTextView;

    public CountDownTimerUtils(TextView textView, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.mTextView = textView;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mTextView.setClickable(false); //设置不可点击
        mTextView.setText(millisUntilFinished / 1000 + "秒后可重新发送");  //设置倒计时时间
//        mTextView.setBackgroundResource(R.drawable.bg_identify_code_press); //设置按钮为灰色，这时是不能点击的
        mTextView.setTextColor(Color.parseColor("#999999"));

        SpannableString spannableString = new SpannableString(mTextView.getText().toString());  //获取按钮上的文字
//        ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#E2B78D"));

        spannableString.setSpan(span, 0, millisUntilFinished / 1000 >= 10?2:1 , Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//将倒计时的时间设置为红色 这个地方是有问题的因为你在单数的倒计时后会文字也会被染红
        mTextView.setText(spannableString);
    }

    @Override
    public void onFinish() {
        mTextView.setText("重新获取验证码");
        mTextView.setClickable(true);//重新获得点击
//        mTextView.setBackgroundResource(R.drawable.bg_identify_code_normal);  //还原背景色
        mTextView.setTextColor(Color.parseColor("#E2B78D"));

    }
}