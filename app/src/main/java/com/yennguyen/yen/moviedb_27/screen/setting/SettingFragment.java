package com.yennguyen.yen.moviedb_27.screen.setting;

import android.support.v4.app.Fragment;

public class SettingFragment extends Fragment {
    private static SettingFragment sSettingFragment;

    public static SettingFragment newInstance() {
        sSettingFragment = new SettingFragment();
        return sSettingFragment;
    }
}
