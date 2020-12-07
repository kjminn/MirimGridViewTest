package kr.ac.ssu.kjminn.mirimgridviewtest;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {
    Context context;
    int[] imgRes = {R.drawable.poster01, R.drawable.poster02, R.drawable.poster03, R.drawable.poster04, R.drawable.poster05,
            R.drawable.poster06,R.drawable.poster07,R.drawable.poster08,R.drawable.poster09,R.drawable.poster10,
            R.drawable.poster11,R.drawable.poster12,R.drawable.poster13,R.drawable.poster14,R.drawable.poster15,
            R.drawable.poster16, R.drawable.poster01, R.drawable.poster02, R.drawable.poster03, R.drawable.poster04
    };

    String[] posterTitles = {"스파이더맨", "백두산", "Eclipse", "라라랜드", "반도", "기생충", "레미제라블",
                            "위대한 쇼맨", "SKYSCRAPER", "신과 함께", "친절한 금자씨", "A Hard Day", "라붐",
                            "유콜잇러브", "Brave Heart", "포레스트 검프", "스파이더맨", "백두산", "Eclipse", "라라랜드"};

    public GridAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgRes.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new GridView.LayoutParams(300, 400));
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imgv.setPadding(5,5,5,5);
        imgv.setImageResource(imgRes[position]);
        final int pos = position;
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = View.inflate(context, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                ImageView imgvPoster = dialogView.findViewById(R.id.imgv_dialog);
                imgvPoster.setImageResource(imgRes[pos]);
                dlg.setTitle(posterTitles[pos]);
                dlg.setIcon(R.drawable.movie);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });
        return imgv;
    }
}
