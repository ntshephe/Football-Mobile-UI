package adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import parent_fragments.Chats_Fragment;

import parent_fragments.LineUp_Fragment;
import parent_fragments.newsFragment;
import parent_fragments.fixture_fragment;
import parent_fragments.sqaudFragment;
import parent_fragments.standingsFragment;

public class mainViewPager extends FragmentStateAdapter {

    public mainViewPager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0: return new sqaudFragment();
            case 1: return new fixture_fragment();
            case 2: return new LineUp_Fragment();
            case 3: return new standingsFragment();
            case 4: return new newsFragment();
            default: return new Chats_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
