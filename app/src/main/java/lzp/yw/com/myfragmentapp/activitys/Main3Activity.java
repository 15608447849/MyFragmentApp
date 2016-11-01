package lzp.yw.com.myfragmentapp.activitys;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lzp.yw.com.myfragmentapp.R;
import lzp.yw.com.myfragmentapp.fragments.ContactFragment;
import lzp.yw.com.myfragmentapp.fragments.MessageFragment;
import lzp.yw.com.myfragmentapp.fragments.NewsFragment;
import lzp.yw.com.myfragmentapp.fragments.SettingFragment;

public class Main3Activity extends AppCompatActivity {//implements View.OnClickListener {





    /**
     * 用于对Fragment进行管理
     */
    public FragmentManager fragmentManager;
    /**
     * 在Tab布局上显示消息标题的控件
     */
    @BindView(R.id.message_text)
    public TextView messageText;

    /**
     * 在Tab布局上显示联系人标题的控件
     */
    @BindView(R.id.contacts_text)
    public TextView contactsText;

    /**
     * 在Tab布局上显示动态标题的控件
     */
    @BindView(R.id.news_text)
    public TextView newsText;

    /**
     * 在Tab布局上显示设置标题的控件
     */
    @BindView(R.id.setting_text)
    public TextView settingText;


    /**
     * 在Tab布局上显示消息图标的控件
     */
    @BindView(R.id.message_image)
    public ImageView messageImage;

    /**
     * 在Tab布局上显示联系人图标的控件
     */
    @BindView(R.id.contacts_image)
    public ImageView contactsImage;

    /**
     * 在Tab布局上显示动态图标的控件
     */
    @BindView(R.id.news_image)
    public ImageView newsImage;

    /**
     * 在Tab布局上显示设置图标的控件
     */
    @BindView(R.id.setting_image)
    public ImageView settingImage;



    /**
     * 消息界面布局
     */
    @BindView(R.id.message_layout)
    public View messageLayout;
    /**
     * 联系人界面布局
     */
    @BindView(R.id.contacts_layout)
    public View contactsLayout;

    /**
     * 动态界面布局
     */
    @BindView(R.id.news_layout)
    public View newsLayout;

    /**
     * 设置界面布局
     */
    @BindView(R.id.setting_layout)
    public View settingLayout;




    /**
     * 用于展示消息的Fragment
     */
    public MessageFragment messageFragment;
    /**
     * 用于展示联系人的Fragment
     */
    public ContactFragment contactsFragment;
    /**
     * 用于展示动态的Fragment
     */
    public NewsFragment newsFragment;
    /**
     * 用于展示设置的Fragment
     */
    public SettingFragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        // 初始化布局元素
//        initOclick();
        initFragmentManager();
    }

    public void initFragmentManager() {
        fragmentManager = getFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(0);
    }

    public void initOclick() {
     /*   messageLayout.setOnClickListener(this);
        contactsLayout.setOnClickListener(this);
        newsLayout.setOnClickListener(this);
        settingLayout.setOnClickListener(this);*/
    }


//
    @OnClick({R.id.message_layout,R.id.contacts_layout,R.id.news_layout,R.id.setting_layout})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_layout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(0);
                break;
            case R.id.contacts_layout:
                // 当点击了联系人tab时，选中第2个tab
                setTabSelection(1);
                break;
            case R.id.news_layout:
                // 当点击了动态tab时，选中第3个tab
                setTabSelection(2);
                break;
            case R.id.setting_layout:
                // 当点击了设置tab时，选中第4个tab
                setTabSelection(3);
                break;

        }
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    public void hideFragments(FragmentTransaction transaction) {
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (contactsFragment != null) {
            transaction.hide(contactsFragment);
        }
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }

}
    /**
     * 清除选中状态
     */
    public void clearSelection() {
        messageImage.setImageResource(R.drawable.message_unselected);
        messageText.setTextColor(Color.parseColor("#82858b"));

        contactsImage.setImageResource(R.drawable.contacts_unselected);
        contactsText.setTextColor(Color.parseColor("#82858b"));

        newsImage.setImageResource(R.drawable.news_unselected);
        newsText.setTextColor(Color.parseColor("#82858b"));

        settingImage.setImageResource(R.drawable.setting_unselected);
        settingText.setTextColor(Color.parseColor("#82858b"));
    }
    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index
     *            每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
     */
    public void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);

        switch (index) {
            case 0:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                messageImage.setImageResource(R.drawable.message_selected);
                messageText.setTextColor(Color.WHITE);
                if (messageFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.content, messageFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(messageFragment);
                }
                break;
            case 1:
                // 当点击了联系人tab时，改变控件的图片和文字颜色
                contactsImage.setImageResource(R.drawable.contacts_selected);
                contactsText.setTextColor(Color.WHITE);
                if (contactsFragment == null) {
                    // 如果ContactsFragment为空，则创建一个并添加到界面上
                    contactsFragment = new ContactFragment();
                    transaction.add(R.id.content, contactsFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                    transaction.show(contactsFragment);
                }
                break;
            case 2:
                // 当点击了动态tab时，改变控件的图片和文字颜色
                newsImage.setImageResource(R.drawable.news_selected);
                newsText.setTextColor(Color.WHITE);
                if (newsFragment == null) {
                    // 如果NewsFragment为空，则创建一个并添加到界面上
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.content, newsFragment);
                } else {
                    // 如果NewsFragment不为空，则直接将它显示出来
                    transaction.show(newsFragment);
                }
                break;
            case 3:
            default:
                // 当点击了设置tab时，改变控件的图片和文字颜色
                settingImage.setImageResource(R.drawable.setting_selected);
                settingText.setTextColor(Color.WHITE);
                if (settingFragment == null) {
                    // 如果SettingFragment为空，则创建一个并添加到界面上
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.content, settingFragment);
                } else {
                    // 如果SettingFragment不为空，则直接将它显示出来
                    transaction.show(settingFragment);
                }
                break;
        }

        transaction.commit();

    }

}
