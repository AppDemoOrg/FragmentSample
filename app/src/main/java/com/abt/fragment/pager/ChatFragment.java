package com.abt.fragment.pager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.abt.fragment.R;

/**
 * @描述：     @Fragment生命周期
 * @作者：     @黄卫旗
 * @创建时间： @21/05/2018
 */
public class ChatFragment extends Fragment {

    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * 初始化Fragment的布局
         */
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_chat, null);
        }
        ((TextView) mView.findViewById(R.id.mTextView)).setText("聊天界面");
        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        /**
         * onDestroyView()：销毁与Fragment有关的视图，但未与Activity解除绑定，
         * 依然可以通过onCreateView方法重新创建视图。
         * 通常在ViewPager+Fragment的方式下会调用此方法。
         */
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /***
         * onAttach()：执行该方法时，Fragment与Activity已经完成绑定，
         * 该方法有一个Activity类型的参数，代表绑定的Activity，
         * 这时候你可以执行诸如mActivity=activity的操作。
         */
    }

    @Override
    public void onDetach() {
        super.onDetach();
        /**
         * onDetach()：解除与Activity的绑定。
         * 在onDestroy方法之后调用。
         */
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /***
         * onActivityCreated()：执行该方法时，与Fragment绑定的Activity的onCreate方法已经执行完成并返回，
         * 在该方法内可以进行与Activity交互的UI操作，所以在该方法之前Activity的onCreate方法并未执行完成，
         * 如果提前进行交互操作，会引发空指针异常。
         */
    }

}
