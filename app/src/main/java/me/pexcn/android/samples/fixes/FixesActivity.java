package me.pexcn.android.samples.fixes;

import me.pexcn.android.samples.R;
import me.pexcn.android.samples.base.BaseListActivity;

/**
 * Created by pexcn on 2017-03-17.
 */
public class FixesActivity extends BaseListActivity {
    @Override
    public String[] getActivityList() {
        return getResources().getStringArray(R.array.activity_titles_sub_fixes);
    }

    @Override
    protected void startSubActivity(int position) {
        switch (position) {
            case 0:
                setSubActivity(position, ListNestedScrollActivity.class);
                break;
            case 1:
                setSubActivity(position, NestedScrollViewActivity.class);
                break;
        }
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
