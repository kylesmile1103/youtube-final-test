package com.finaltest.youtube;

import java.util.ArrayList;
import java.util.List;

public class Youtuber implements IVideo, IViewer {
    private double id;
    private String name;
    private List<Video> videoList;
    private List<Viewer> viewerList;
    private String category;

    public Youtuber(double id, String name) {
        this.id = id;
        this.name = name;
        this.videoList = new ArrayList<>();
        this.viewerList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public enum Category {
        MUSIC(1),
        SPORT(2),
        ANIMAL(3),
        KID(4),
        NEWS(5),
        TECH(6),
        CAR(7);

        private final int cat;

        Category(int i) {
            this.cat = i;
        }

        public int getCategory() {
            return this.cat;
        }
    }

    public void setCategory(int cat) {
        Category[] categories = Category.values();
        for (Category c : categories) {
            if (cat == c.getCategory()) {
                this.category = c.name();
            }
        }
    }

    public String getCategory() {
        return this.category;
    }

    @Override
    public void addVideo(Video video) {
        if (!this.videoList.contains(video)) {
            this.videoList.add(video);
        }
    }

    @Override
    public Video searchVideo(double id) {
        for (Video v : this.videoList)
            if (id == v.getId())
                return v;
        return null;
    }

    @Override
    public void updateVideo(Video video, String title) {
        video.setTitle(title);
    }

    @Override
    public void deleteVideo(Video video) {
        this.videoList.remove(video);
    }

    @Override
    public void exportVideoList(String path) {
        WriteFile wt = new WriteFile();
        wt.setContent(this.videoList);
        wt.writeListToFile(path);
    }

    @Override
    public void addViewer(Viewer viewer) {
        if (!this.viewerList.contains(viewer)) {
            this.viewerList.add(viewer);
            viewer.getSubNotification(this);
        }
    }

    @Override
    public Viewer searchViewer(double id) {
        for (Viewer v : this.viewerList)
            if (id == v.getId())
                return v;
        return null;
    }


    @Override
    public void deleteViewer(Viewer viewer) {
        this.viewerList.remove(viewer);
        viewer.getUnSubNotification(this);
    }

    @Override
    public void exportViewerList(String path) {
        WriteFile wt = new WriteFile();
        wt.setContent(this.viewerList);
        wt.writeListToFile(path);
    }

    public List<Video> getVideoList() {
        return this.videoList;
    }

    public double getId() {
        return id;
    }

    public void onNotification() {
        for (Viewer vw : this.viewerList) {
            for (Video vid : this.videoList) {
                vw.getNewVideoNotification(this, vid);
            }
        }
    }

    @Override
    public String toString() {
        return "Youtuber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
