package com.uttampanchasara.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.uttampanchasara.loginuiandroid.R;

/**
 * @since 1/1/2019
 */
public class MaterialEditText extends FrameLayout {

    private float edtTextSize = 18f;
    private int edtTextColor;
    private String edtText = "";
    private String labelText = "";
    private int edtBackground;
    private int labelTextColor;

    private String edtHint = "";

    private int edtPaddingStart = 10;
    private int edtPaddingTop = 10;
    private int edtPaddingBottom = 10;
    private int edtPaddingEnd = 10;
    private int labelBackgroundColor;

    public MaterialEditText(@NonNull Context context) {
        super(context);
        initView();
    }

    public MaterialEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.MaterialEditText, 0, 0);

        edtTextSize = attributes.getDimension(R.styleable.MaterialEditText_mtEdtTextSize, edtTextSize);
        edtTextColor = attributes.getColor(R.styleable.MaterialEditText_mtEdtTextColor, getResources().getColor(android.R.color.black));
        edtBackground = attributes.getResourceId(R.styleable.MaterialEditText_mtEdtBackground, R.drawable.bg_input_layout);
        edtText = attributes.getString(R.styleable.MaterialEditText_mtEdtText);
        edtHint = attributes.getString(R.styleable.MaterialEditText_mtEdtHint);
        labelText = edtHint;

        edtPaddingStart = attributes.getDimensionPixelSize(R.styleable.MaterialEditText_mtEdtPaddingStart, edtPaddingStart);
        edtPaddingTop = attributes.getDimensionPixelSize(R.styleable.MaterialEditText_mtEdtPaddingTop, edtPaddingTop);
        edtPaddingBottom = attributes.getDimensionPixelSize(R.styleable.MaterialEditText_mtEdtPaddingBottom, edtPaddingBottom);
        edtPaddingEnd = attributes.getDimensionPixelSize(R.styleable.MaterialEditText_mtEdtPaddingEnd, edtPaddingEnd);

        //labelText = attributes.getString(R.styleable.MaterialEditText_mtLabelText);
        labelTextColor = attributes.getColor(R.styleable.MaterialEditText_mtLabelTextColor, getResources().getColor(R.color.colorPrimary));
        labelBackgroundColor = attributes.getColor(R.styleable.MaterialEditText_mtLabelTextBackgroundColor, getResources().getColor(android.R.color.white));
        initView();
    }

    public MaterialEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View view = inflate(getContext(), R.layout.material_layout, null);

        final EditText editText = view.findViewById(R.id.editText);
        final TextView txtLabel = view.findViewById(R.id.txtLabel);
        txtLabel.setTextColor(labelTextColor);
        txtLabel.setBackgroundColor(labelBackgroundColor);
        txtLabel.setText(labelText);

        editText.setText(edtText);
        float sp = edtTextSize / getResources().getDisplayMetrics().scaledDensity;
        editText.setTextSize(sp);
        editText.setTextColor(edtTextColor);
        editText.setSelection(editText.getText().length());
        editText.setBackgroundResource(edtBackground);
        editText.setPadding(edtPaddingStart, edtPaddingTop, edtPaddingEnd, edtPaddingBottom);
        editText.setHint(edtHint);
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editText.setHint("");
                    txtLabel.setVisibility(VISIBLE);
                } else {
                    if (editText.getText().toString().isEmpty()) {
                        txtLabel.setVisibility(GONE);
                        editText.setHint(edtHint);
                    }
                }
            }
        });


        int measuredWidth = txtLabel.getMeasuredWidth() + 20;
        Log.e("MaterialEditText", "width :" + measuredWidth);
        editText.setWidth(measuredWidth);

        addView(view);
    }
}