package net.androidbootcamp.anthologyweddingphotography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] WedPhotos = {R.drawable.beach, R.drawable.cake, R.drawable.ceremony, R.drawable.cheers, R.drawable.cupcakes, R.drawable.flowers, R.drawable.macarons, R.drawable.oceanside, R.drawable.rehearsal, R.drawable.silhouettes};

    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView foot = (TextView) findViewById(R.id.txtFooter);

        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView photo = (ImageView)findViewById(R.id.imgExpanded);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Anthology Wedding Photo " + (position + 1), Toast.LENGTH_SHORT).show();
                photo.setImageResource(WedPhotos[position]);

                foot.setText("Contact us at anthology@wed.com");
            }
        });
    }

    public class ImageAdapter extends BaseAdapter{
        private Context context;

        public ImageAdapter(Context cont) {
            context = cont;
        }

        @Override
        public int getCount() {
            return WedPhotos.length;
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
            photo = new ImageView(context);
            photo.setImageResource(WedPhotos[position]);
            photo.setScaleType(ImageView.ScaleType.FIT_XY);
            photo.setLayoutParams(new GridView.LayoutParams(330, 300));
            return photo;
        }
    }
}
