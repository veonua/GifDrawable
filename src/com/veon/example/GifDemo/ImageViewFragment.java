package com.veon.example.GifDemo;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.okhttp.OkHttpClient;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Fragment with image view and progress indicator
 *
 * Created by Veon on 1/4/14.
 */
public class ImageViewFragment extends Fragment {
    private ImageView mImageView;
    private View mProgressContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.page, container, false);
        assert v != null;
        mImageView = (ImageView) v.findViewById(android.R.id.primary);
        mProgressContainer = v.findViewById(R.id.progressContainer);
        startLoader();
        return v;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (mImageView == null) return;

        Drawable d = mImageView.getDrawable();
        if (d != null && d instanceof Animatable)
        {
            if (isVisibleToUser)
                ((Animatable)d).start();
            else
                ((Animatable)d).stop();
        }
    }

    public void startLoader() {
        mProgressContainer.setVisibility(View.VISIBLE);
        mImageView.setVisibility(View.INVISIBLE);
        new AsyncTask<String, Void, GifAnimationDrawable>() {

            @Override
            protected GifAnimationDrawable doInBackground(String... strings) {
                try {
                    URL url = new URL(strings[0]);

                    DemoActivity activity = ((DemoActivity) getActivity());
                    if (activity == null) return null;
                    OkHttpClient client = activity.client;
                    if (client == null) return null;

                    HttpURLConnection urlConnection = client.open(url);
                    urlConnection.setUseCaches(true);
                    try {
                        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                        GifAnimationDrawable r = new GifAnimationDrawable(in);
                        // pre-load first frame to display as placeholder while not playing
                        r.preloadFirstFrame();
                        return r;
                    } finally {
                        urlConnection.disconnect();
                    }
                } catch (Exception e) {
                    Log.e("TAG", "Loader", e);
                    return null;
                }
            }

            @Override
            protected void onPostExecute(GifAnimationDrawable gifAnimationDrawable) {
                mProgressContainer.setVisibility(View.GONE);
                mImageView.setVisibility(View.VISIBLE);
                if (gifAnimationDrawable == null) {
                    mImageView.setImageResource(R.drawable.ic_launcher);
                    return;
                }
                mImageView.setImageDrawable(gifAnimationDrawable);

                if (getUserVisibleHint())
                    gifAnimationDrawable.start();
            }
        }.execute(getArguments().getString("id"));
    }
}
