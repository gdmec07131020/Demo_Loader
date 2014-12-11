package cn.edu.gdmec.s07131020.demo_loader;

import java.util.ArrayList;
import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
private ListView listView;
private ArrayAdapter<Book> adapter;
private LoaderManager manager;
private List<Book> books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   
        listView=(ListView)findViewById(R.id.listView);
    
        manager=getLoaderManager();
        
        manager.initLoader(0, null, new LoaderCallbacks<Cursor>(){

			@Override
			public Loader<Cursor> onCreateLoader(int id, Bundle args) {
				Uri uri=Uri.parse("content://com.kaikeba.providers.book/book");
				return new CursorLoader(MainActivity.this,uri,null,null,null,null);
			}

			@Override
			public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
				books=new ArrayList<Book>();
				
				while(data.moveToNext()){
					String id=data.getString(data.getColumnIndex("_id"));
					String name=data.getString(data.getColumnIndex("name"));
					float price=data.getFloat(data.getColumnIndex("price"));
					String publisher=data.getString(data.getColumnIndex("publisher"));
				
					Book book=new Book(id,name,price,publisher);
					books.add(book);
				}
				
				if(adapter==null){
					adapter =new ArrayAdapter<Book>(MainActivity.this, 
							android.R.layout.simple_list_item_1,
							android.R.id.text1, books);
				}else{
					adapter.clear();
					adapter.addAll(books);
				}
				adapter.notifyDataSetChanged();
			}

			@Override
			public void onLoaderReset(Loader<Cursor> loader) {
				// TODO Auto-generated method stub
				
			}
        	
        });
    }


   
}
