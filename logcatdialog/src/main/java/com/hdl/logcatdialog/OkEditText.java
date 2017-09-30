package com.hdl.logcatdialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import logcatview.hdl.com.logcatdialog.R;

/**
 * 带确定按钮的输入框
 * Created by HDL on 2017/9/30.
 */

public class OkEditText extends LinearLayout {

    private ImageView ivSearch, ivOk;
    private EditText etContent;

    public OkEditText(Context context) {
        this(context, null);
    }

    public OkEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OkEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        View view = View.inflate(context, R.layout.ok_edittext, null);
        ivSearch = (ImageView) view.findViewById(R.id.iv_search);
        ivOk = (ImageView) view.findViewById(R.id.iv_ok);
        etContent = (EditText) view.findViewById(R.id.et_content);
        addView(view);
        setListener();
    }

    private void setListener() {
        ivSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ivOk.setVisibility(VISIBLE);
                etContent.setVisibility(VISIBLE);
            }
        });
        ivOk.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickOkListener != null) {
                    onClickOkListener.onOk(etContent.getText().toString().trim());
                }
            }
        });
    }

    private OnClickOkListener onClickOkListener;

    public void setOnClickOkListener(OnClickOkListener onClickOkListener) {
        this.onClickOkListener = onClickOkListener;
    }

    public interface OnClickOkListener {
        void onOk(String content);
    }
}
