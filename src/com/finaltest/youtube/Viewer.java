package com.finaltest.youtube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Viewer implements IYoutuber {
    private double id;
    private String name;
    private String[] interest;
    private List<Youtuber> ytList;
    private List<Video> watchList;
    private Video curWatch;

    public Viewer(double id, String name) {
        this.id = id;
        this.name = name;
        this.ytList = new ArrayList<>();
        this.watchList = new ArrayList<>();
    }

    public void subscribe(Youtuber youtuber) {
        youtuber.addViewer(this);
        this.ytList.add(youtuber);
    }

    public void unsubscribe(Youtuber youtuber) {
        youtuber.deleteViewer(this);
        this.ytList.remove(youtuber);
    }

    public void getSubNotification(Youtuber channel) {
        System.out.println("Thank " + this.name + " for subscribing to: " + channel.getName());
    }

    public void getUnSubNotification(Youtuber channel) {
        System.out.println(this.name + " have unsubscribed to: " + channel.getName());
    }

    public void getNewVideoNotification(Youtuber channel, Video video) {
        System.out.println("New video on " + channel.getName() + " channel: " + video.getTitle());
    }

    public void setInterest(String[] interests) {
        this.interest = interests;
    }

    public void watchVideo(Video video) throws InterruptedException {
        System.out.println(this.name + " are watching: " + video.getTitle());
        synchronized (this) {
            watchList.add(video);
            this.curWatch = video;
        }

    }

    public double getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    @Override
    public Youtuber searchYT(double id) {
        for (Youtuber v : this.ytList)
            if (id == v.getId())
                return v;
        return null;
    }

    @Override
    public void exportYoutuberList(String path) {
        WriteFile wt = new WriteFile();
        wt.setContent(this.ytList);
        wt.writeListToFile(path);
    }

    @Override
    public String toString() {
        return "Viewer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", interest=" + Arrays.toString(interest) +
                ", ytList=" + ytList +
                '}';
    }


}
