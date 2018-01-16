package forfun.good.a2018011601;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void CL1(View view) {
        String str = getFilesDir().getAbsolutePath();
        Log.d("FILE", str);
        String str1 = getCacheDir().getAbsolutePath();
        Log.d("FILE", str1);

        File f = new File(getFilesDir(), "myF");
        try {
            FileWriter fw = new FileWriter(f);
            fw.write("testtttttttttttt");
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CL2(View v) {
        ArrayList<String> mylist = new ArrayList();
        mylist.add("AAA");
        mylist.add("BBB");
        mylist.add("CCC");
        File f = new File(getFilesDir(), "myF.txt");
        try {
            FileWriter fw = new FileWriter(f);
            Gson gson = new Gson();
            String data = gson.toJson(mylist);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void CL3(View v) {
        ArrayList<Student> mydata = new ArrayList();
        mydata.add(new Student(1, "jon", 95));
        mydata.add(new Student(2, "son", 95));
        mydata.add(new Student(3, "kon", 95));
        mydata.add(new Student(4,"sam",74));

        File f = new File(getFilesDir(), "myfile2.txt");
        try {
            FileWriter fw = new FileWriter(f);
            Gson gson = new Gson();
            String data = gson.toJson(mydata);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    class Student {
        public int id;
        public String name;
        public int score;

        public Student(int id, String name, int score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }

    }

    public void CL4(View v) {
        File f = new File(getFilesDir(), "myF.txt");//開啟目標txt
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Log.d("FILE", str);
            Gson gson = new Gson();
            ArrayList<String> mydata = gson.fromJson(str, new TypeToken<ArrayList<String>>() {
            }.getType());
            for (String s : mydata) {
                Log.d("FILE", "data:" + s);

            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public void CL5 (View v) //寫資料讀資料
    {
        File f = new File(getFilesDir(), "myfile2.txt");//開啟目標txt
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Log.d("FILE", str);
            Gson gson = new Gson();
            ArrayList<Student> mydata = gson.fromJson(str, new TypeToken<ArrayList<Student>>() //抓叫做Student的陣列
            {
            }.getType());
            for (Student s : mydata) {
                Log.d("FILE", "詳細資料:" + s.id +","+s.name+","+s.score);

            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void CL6(View v)
    {
        File f = Environment.getExternalStorageDirectory();
        Log.d("FILE", f.getAbsolutePath());
    }

}
