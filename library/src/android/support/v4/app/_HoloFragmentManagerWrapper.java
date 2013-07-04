
package android.support.v4.app;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

import org.holoeverywhere.HoloEverywhere;

import android.os.Bundle;
import android.support.v4.app.Fragment.SavedState;

public class _HoloFragmentManagerWrapper extends FragmentManager {
    private FragmentManagerImpl mImpl;

    public _HoloFragmentManagerWrapper(FragmentManagerImpl impl) {
        mImpl = impl;
    }

    @Override
    public FragmentTransaction beginTransaction() {
        return mImpl.beginTransaction();
    }

    @Override
    public boolean executePendingTransactions() {
        final List<Fragment> active = mImpl.mActive;
        if (active != null && active.size() > 0) {
            for (int i = 0; i < active.size(); i++) {
                final Fragment f = active.get(i);
                if (f != null && f.mSavedFragmentState != null) {
                    f.mSavedFragmentState.setClassLoader(HoloEverywhere.class.getClassLoader());
                }
            }
        }
        return mImpl.executePendingTransactions();
    }

    @Override
    public Fragment findFragmentById(int id) {
        return mImpl.findFragmentById(id);
    }

    @Override
    public Fragment findFragmentByTag(String tag) {
        return mImpl.findFragmentByTag(tag);
    }

    @Override
    public void popBackStack() {
        mImpl.popBackStack();
    }

    @Override
    public boolean popBackStackImmediate() {
        return mImpl.popBackStackImmediate();
    }

    @Override
    public void popBackStack(String name, int flags) {
        mImpl.popBackStack(name, flags);
    }

    @Override
    public boolean popBackStackImmediate(String name, int flags) {
        return mImpl.popBackStackImmediate(name, flags);
    }

    @Override
    public void popBackStack(int id, int flags) {
        mImpl.popBackStack(id, flags);
    }

    @Override
    public boolean popBackStackImmediate(int id, int flags) {
        return mImpl.popBackStackImmediate(id, flags);
    }

    @Override
    public int getBackStackEntryCount() {
        return mImpl.getBackStackEntryCount();
    }

    @Override
    public BackStackEntry getBackStackEntryAt(int index) {
        return mImpl.getBackStackEntryAt(index);
    }

    @Override
    public void addOnBackStackChangedListener(OnBackStackChangedListener listener) {
        mImpl.addOnBackStackChangedListener(listener);
    }

    @Override
    public void removeOnBackStackChangedListener(OnBackStackChangedListener listener) {
        mImpl.removeOnBackStackChangedListener(listener);
    }

    @Override
    public void putFragment(Bundle bundle, String key, Fragment fragment) {
        mImpl.putFragment(bundle, key, fragment);
    }

    @Override
    public Fragment getFragment(Bundle bundle, String key) {
        return mImpl.getFragment(bundle, key);
    }

    @Override
    public SavedState saveFragmentInstanceState(Fragment f) {
        return mImpl.saveFragmentInstanceState(f);
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        mImpl.dump(prefix, fd, writer, args);
    }
}
