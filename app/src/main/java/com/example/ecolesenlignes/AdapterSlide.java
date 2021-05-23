package com.example.ecolesenlignes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class AdapterSlide extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public AdapterSlide(Context context){
        this.context=context;
    }
    //Arrays
    public int[] slide_image = {R.drawable.logo, R.drawable.ic_register, R.drawable.ic_register, R.drawable.ic_quiz};

    public String[] slide_heading={"Bienvenue dans votre application ECOLE EN LIGNE","Ameliorez vos competances"+" dans tous les cours!","Dans votre ecole en ligne"," "+"Faites nos quiz!"};
    public String[] slide_desc={"Révisez tous vos cours, tous les jours","Des cours pour tout comprendre", "Des cours"+" dispo pour toutes les matières en video et pdf", "Des trés bon exercice pour "+" améliorer votre niveau"};

    @Override
    public int getCount() {
        return slide_desc.length;
    }

    @Override
    public boolean isViewFromObject( View view,  Object object) {
        return view == (RelativeLayout)object;
    }


    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view= layoutInflater.inflate(R.layout.slide_layout, container, false);
        ImageView slideimageview= view.findViewById(R.id.slide_image);
        TextView slideheading = view.findViewById(R.id.slide_heading);
        TextView slidedesc = view.findViewById(R.id.slide_desc);

        slideimageview.setImageResource(slide_image[position]);
        slideheading.setText(slide_heading[position]);
        slidedesc.setText( slide_desc[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
