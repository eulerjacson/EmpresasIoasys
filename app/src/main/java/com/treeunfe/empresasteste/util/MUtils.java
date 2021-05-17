package com.treeunfe.empresasteste.util;

import android.app.ProgressDialog;
import android.content.Context;

import com.treeunfe.empresasteste.R;
import com.treeunfe.empresasteste.repository.MemoryRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MUtils {

    private static MemoryRepository memoryRepository;

    public static MemoryRepository getMemoryRepository() {
        if (memoryRepository == null) {
            memoryRepository = new MemoryRepository();
        }
        return memoryRepository;
    }

    /////////////////////
    public static ProgressDialog getProgressDialog(Context contextView) {
        ProgressDialog pd = new ProgressDialog(contextView);
        pd.setMessage(contextView.getString(R.string.loading));
        pd.setCancelable(false);
        return pd;
    }

    public static boolean validarEmail(String email){
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
