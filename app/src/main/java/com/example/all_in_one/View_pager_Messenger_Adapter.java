package com.example.all_in_one;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class View_pager_Messenger_Adapter extends FragmentPagerAdapter {
    public View_pager_Messenger_Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0) return new Chat_Fragment();
        else if(position ==1) return new Status_Fragment();
        else return new Call_Fragment();
    }

    @Override
    public int getCount() {
        return 3; // number of Fragment
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) return "Chat";
        else if(position == 1) return "Status";
        else return "Call";
    }
}
