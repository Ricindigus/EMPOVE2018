package com.example.ricindigus.empove2018.util;

import android.text.InputFilter;
import android.text.Spanned;

public class InputFilterSoloLetras implements InputFilter {
    @Override
    public CharSequence filter(CharSequence src, int start,
                               int end, Spanned dst, int dstart, int dend) {
        if(src.toString().matches("[a-zA-Z ]+")){
            return src;
        }
        return "";
    }
}