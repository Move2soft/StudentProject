package com.move2soft.android.Fragmnet;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.move2soft.android.R;
import com.shockwave.pdfium.PdfDocument;

import java.io.File;
import java.util.List;


public class Syllabus extends Fragment implements OnPageChangeListener, OnLoadCompleteListener {

    public static final String SAMPLE_FILE = "a.pdf";
    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName;



    public Syllabus() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_syllabus, container, false);

        pdfView= (PDFView) view.findViewById(R.id.pdfView);
        displayFromAsset(SAMPLE_FILE);

        return view;
    }
    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(pageNumber)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(getActivity()))
                .load();
    }


    @Override
    public void onPageChanged(int page, int pageCount) {

    }

    @Override
    public void loadComplete(int nbPages) {

    }


}
