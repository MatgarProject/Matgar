package com.example.elashry.matgar.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.elashry.matgar.R;

import java.util.HashMap;

public class Web extends Fragment implements  BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{
    private SliderLayout mDemoSlider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

     init_View();
        return inflater.inflate(R.layout.fragment_web, container, false);

    }


    public void init_View() {
        mDemoSlider = (SliderLayout) getActivity().findViewById(R.id.slider);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("كاميرات مراقبه", R.drawable.fac);
        file_maps.put("تطبيقات موبيل ", R.drawable.fac);
        file_maps.put("كاميرا ثلاثيه", R.drawable.fac);
        file_maps.put("تسويق منتجات", R.drawable.fac);
        file_maps.put("تصميم لوجهات واعلانات", R.drawable.fac);
        file_maps.put("تصميم مواقع", R.drawable.fac);
        file_maps.put("تصميم بوسترات ومنيوهات", R.drawable.fac);


        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView.description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);
//            mDemoSlider.addSlider(textSliderView);
        }
//        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
//        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
//        mDemoSlider.setDuration(2000);
//        mDemoSlider.addOnPageChangeListener(this);


    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
