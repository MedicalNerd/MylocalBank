package sg.edu.rp.c346.id22021421.mylocalbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
TextView DBS,UOB,OCBC,Title;
String lang = "";
String bankClicked = "";
String weblink = "";
String number = "";
ToggleButton dbs,uob,ocbc;
long num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBS=findViewById(R.id.textViewDBS);
        UOB=findViewById(R.id.textViewUOB);
        OCBC=findViewById(R.id.textViewOCBC);
        Title=findViewById(R.id.textViewTitle);
        dbs=findViewById(R.id.TogglebuttonDBSfav);
        uob=findViewById(R.id.TogglebuttonUOBfav);
        ocbc=findViewById(R.id.TogglebuttonOCBC);
        registerForContextMenu(DBS);
        registerForContextMenu(UOB);
        registerForContextMenu(OCBC);
        dbs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    DBS.setTextColor(Color.RED);
                } else {
                    DBS.setTextColor(Color.WHITE);
                }
            }
        });
        uob.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    UOB.setTextColor(Color.RED);
                } else {
                    UOB.setTextColor(Color.WHITE);
                }
            }
        });
        ocbc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    OCBC.setTextColor(Color.RED);
                } else {
                    OCBC.setTextColor(Color.WHITE);
                }
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"website");
        menu.add(0,1,1,"Contact Bank");
        if(v == DBS){
            bankClicked="DBS";
        }
        else if(v == UOB){
            bankClicked="UOB";
        }
        else if(v == OCBC){
            bankClicked="OCBC";
        }

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.EnglishSelection){
            DBS.setText(lang=getString(R.string.DBS));
            UOB.setText(lang=getString(R.string.UOB));
            OCBC.setText(lang=getString(R.string.OCBC));
            Title.setText(lang=getString(R.string.LocalBank));
            return true;



        }
        else if(id==R.id.ChineseSelection){
                DBS.setText(lang=getString(R.string.chidbs));
                UOB.setText(lang=getString(R.string.chiuob));
                OCBC.setText(lang=getString(R.string.chiocbc));
                Title.setText(lang=getString(R.string.chititle));
                return true;

        }
            return super.onOptionsItemSelected(item);
    }

    public boolean onContextItemSelected(MenuItem item) {
        if(bankClicked.equalsIgnoreCase("DBS")) {
            if(item.getItemId()==0){
                weblink = getString(R.string.dbs);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(weblink));
                startActivity(intent);
            }
            else if(item.getItemId()==1){
                number = getString(R.string.dbsnum);
                num = Long.parseLong(number);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num));
                startActivity(intentCall);
            }
            return true;
        }
        else if(bankClicked.equalsIgnoreCase("UOB")){
            if(item.getItemId()==0){
                weblink = getString(R.string.uob);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(weblink));
                startActivity(intent);
            }
            else if(item.getItemId()==1){
                number = getString(R.string.uobnum);
                num = Long.parseLong(number);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num));
                startActivity(intentCall);
            }
            return true;
        }
        else if(bankClicked.equalsIgnoreCase("OCBC")){
            if(item.getItemId()==0){
                weblink = getString(R.string.ocbc);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(weblink));
                startActivity(intent);
            }
            else if(item.getItemId()==1){
                number = getString(R.string.ocbcnum);
                num = Long.parseLong(number);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num));
                startActivity(intentCall);
            }
            return true;
        }
            return super.onContextItemSelected(item);
        }
}