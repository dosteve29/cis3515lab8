package edu.temple.cis3515lab8;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebFragment extends Fragment {
    private String currentURL = "";

    public WebFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_web, container, false);
        return view;
    }

    public void updateText(String text){
        currentURL = text;
    }

    public String getURL(){
        return currentURL;
    }

    public void loadURL(){
        WebView webView = getView().findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView webView, String url) {
                super.onPageFinished(webView, url);
                currentURL = url;
                EditText editText = getActivity().findViewById(R.id.urlText);
                editText.setText(currentURL, TextView.BufferType.EDITABLE);
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        if (currentURL.contains("https://")){
            webView.loadUrl(currentURL);
        } else{
            webView.loadUrl("https://".concat(currentURL));
        }
    }

}
