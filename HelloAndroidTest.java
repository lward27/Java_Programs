package com.example.helloandroid.test;

import com.example.helloandroid.HelloAndroid;
import android.widget.TextView;
import android.test.ActivityInstrumentationTestCase2;

public class HelloAndroidTest extends ActivityInstrumentationTestCase2<HelloAndroid> {
	
	private HelloAndroid mActivity;
	private TextView mView;
	private String resourceString;
	
	public HelloAndroidTest() {
		super("com.example.helloandroid", HelloAndroid.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = this.getActivity();
		mView = (TextView) mActivity.findViewById(com.example.helloandroid.R.id.textview);
		resourceString = mActivity.getString(com.example.helloandroid.R.string.hello);
	}
	
	public void testPreconditions() {
		assertNotNull(mView);
	}
	
	public void testText() {
		assertEquals(resourceString, (String)mView.getText());
	}
}
