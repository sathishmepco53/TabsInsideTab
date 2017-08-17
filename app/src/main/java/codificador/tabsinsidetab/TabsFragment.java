package codificador.tabsinsidetab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sathish on 8/17/2017.
 */

public class TabsFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tabs, container, false);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs2);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager2);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

            ViewPagerAdapter2 adapter = new ViewPagerAdapter2(getActivity().getSupportFragmentManager());
            TestFragment oneFragment = new TestFragment();
            TestFragment twoFragment = new TestFragment();
            TestFragment threeFragment = new TestFragment();
            oneFragment.setText("Ten");
            twoFragment.setText("Twenty");
            threeFragment.setText("Forty");
            adapter.addFragment(oneFragment, "Ten");
            adapter.addFragment(twoFragment, "Twenty");
            adapter.addFragment(threeFragment, "Forty");
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
    }

    class ViewPagerAdapter2 extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter2(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
