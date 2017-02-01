package com.example.student3.bokunofirstrpg;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    public int curScene = 1;
    LinkedList<Scene> scenes = new LinkedList<Scene>();
    LinkedList<String> lines = new LinkedList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Player.hp=100;
        Player.gold=0;
        Player.mp=50;
        LoadLevels(scenes, lines);
        scenes.get(0).Launch();
    }

    void LoadLevels(LinkedList<Scene> scenes, LinkedList<String> lines) {
        InputStream is;
        try {
            is = getAssets().open("a.txt");
            Scanner scanner = new Scanner(is);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : lines) {
            if (line.startsWith("Level")) {
                String[] input = line.split("@");
                Scene scene = new Scene(input[1], input[2]);
                String input2[] = input[4].split(":");
                for (int i = 0; i < Integer.parseInt(input[3]); i++) {
                    String[] input3 = input2[i * 2 + 1].split(" ");
                    Event event = new Event(Integer.parseInt(input3[0]), Integer.parseInt(input3[1]), Integer.parseInt(input3[2]), input2[i * 2]);
                    scene.events.add(event);
                }
                scenes.add(scene);
            }
        }


    }
}