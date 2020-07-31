package net.bsinc.mnotes.model;

import net.bsinc.mnotes.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Note {
    //Keep these variable names the same as those in the firebase database
    private String title;
    private String content;

    public Note(){}

    public Note(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRandomCardColor(){
        List<Integer> colorCode = new ArrayList<>();
        colorCode.add(R.color.silverPink);
        colorCode.add(R.color.canary);
        colorCode.add(R.color.grannySmithApple);
        colorCode.add(R.color.fireOpal);
        colorCode.add(R.color.beige);
        colorCode.add(R.color.babyPink);
        colorCode.add(R.color.lightStaleGray);
        colorCode.add(R.color.lightPink);
        colorCode.add(R.color.maximumPurple);
        colorCode.add(R.color.azureWebColor);
        colorCode.add(R.color.maroon);
        colorCode.add(R.color.oldRose);
        colorCode.add(R.color.maximumBluePurple);
        colorCode.add(R.color.uranianBlue);
        colorCode.add(R.color.champagnePink);
        colorCode.add(R.color.magicMint);
        colorCode.add(R.color.purpureus);
        colorCode.add(R.color.darkSalmon);
        colorCode.add(R.color.teaGreen);
        colorCode.add(R.color.almond);
        colorCode.add(R.color.deepChampagne);
        colorCode.add(R.color.opal);
        colorCode.add(R.color.lighCyan);
        colorCode.add(R.color.lavendarFloral);
        colorCode.add(R.color.wisteria);

        Random randomColor = new Random();
        int number = randomColor.nextInt(colorCode.size());
        return colorCode.get(number);
    }

}
