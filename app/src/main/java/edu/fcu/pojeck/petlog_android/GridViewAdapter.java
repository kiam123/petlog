package edu.fcu.pojeck.petlog_android;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewAdapter extends BaseAdapter{

	Integer[] data={R.drawable.icon,R.drawable.icon,
					R.drawable.icon,R.drawable.icon,
					R.drawable.icon,R.drawable.icon,
					R.drawable.icon,R.drawable.icon,
					R.drawable.icon};

	private Context context;

	public GridViewAdapter(Context context){
		this.context = context;
	}

	@Override
	public int getCount() {
		return data.length;
	}

	@Override
	public Object getItem(int position) {
		return data[position];//asdasdasd
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView image;
		if(convertView==null){
			image = new ImageView(context);
			image.setLayoutParams(new GridView.LayoutParams(120, 120));
			image.setScaleType(ImageView.ScaleType.CENTER_CROP);
		}else{
			image = (ImageView)convertView;
		}
		image.setImageResource(data[position]);
		return image;
	}

}