package com.radiounju.fi.radiodemo002.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.radiounju.fi.radiodemo002.model.Noticia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucem on 11/28/2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<Noticia> noticiaList;

    public ViewPagerAdapter(FragmentManager fm, List<Noticia> noticiaList) {
        super(fm);
        this.noticiaList = noticiaList;
    }

    @Override
    public Fragment getItem(int position) {
        List<Noticia> cat1 = new ArrayList<>();
        List<Noticia> cat2 = new ArrayList<>();
        List<Noticia> cat3 = new ArrayList<>();
        List<Noticia> cat4 = new ArrayList<>();
        List<Noticia> cat5 = new ArrayList<>();
        List<Noticia> cat6 = new ArrayList<>();
        List<Noticia> cat7 = new ArrayList<>();
        List<Noticia> cat8 = new ArrayList<>();
        for (Noticia noticia : noticiaList) {
            //Log.d("LOGGGGGGG", noticia.toString());
            if(noticia.getCategoria().equals("Nota de Tapa"))
                cat1.add(noticia);
            if(noticia.getCategoria().equals("Destacadas"))
                cat2.add(noticia);
            if(noticia.getCategoria().equals("Deportes"))
                cat3.add(noticia);
            if(noticia.getCategoria().equals("Diálogos en la UNJu"))
                cat4.add(noticia);
            if(noticia.getCategoria().equals("Cátedra Abierta"))
                cat5.add(noticia);
            if(noticia.getCategoria().equals("Agenda Universitaria"))
                cat6.add(noticia);
            if(noticia.getCategoria().equals("Agenda Pública"))
                cat7.add(noticia);
            if(noticia.getCategoria().equals("Gestion Universitaria"))
                cat8.add(noticia);
        }
        FragmentA fragment = null;

        if (position == 0) {
            fragment = new FragmentA();
            fragment.setNoticiaList(cat1);
        } else if (position == 1) {
            fragment = new FragmentA();
            fragment.setNoticiaList(cat2);
        } else if (position == 2) {
            fragment = new FragmentA();
            fragment.setNoticiaList(cat3);
        } else if (position == 3) {
            fragment = new FragmentA();
            fragment.setNoticiaList(cat4);
        } else if (position == 4) {
            fragment = new FragmentA();
            fragment.setNoticiaList(cat5);
        } else if (position == 5) {
            fragment = new FragmentA();
            fragment.setNoticiaList(cat6);
        } else if (position == 6) {
            fragment = new FragmentA();
            fragment.setNoticiaList(cat7);
        } else if (position == 7) {
            fragment = new FragmentA();
            fragment.setNoticiaList(cat8);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Nota de Tapa";
        } else if (position == 1) {
            title = "Destacadas";
        } else if (position == 2) {
            title = "Deportes";
        } else if (position == 3) {
            title = "Diálogos en la UNJu";
        } else if (position == 4) {
            title = "Cátedra Abierta";
        } else if (position == 5) {
            title = "Agenda Universitaria";
        } else if (position == 6) {
            title = "Agenda Pública";
        } else if (position == 7) {
            title = "Gestion Universitaria";
        }
        return title;
    }
}
