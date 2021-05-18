package com.finaltest.youtube;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cau 1
        Video v1 = new Video(1, "Learn Java in 5 minutes!");
        Video v2 = new Video(2, "How to install Java");
        Video v3 = new Video(3, "Java make GUI application");
        Video v4 = new Video(4, "Lamborghini review");
        Video v5 = new Video(5, "Ferrari review");

        List<Youtuber> youtubers = new ArrayList<>();
        Youtuber yt = new Youtuber(1, "Kyle Smile");
        youtubers.add(yt);
        yt.setCategory(6);
        yt.addVideo(v1);
        yt.addVideo(v2);
        yt.addVideo(v3);

        yt.updateVideo(v3,"Make GUI with JAVA Spring");

        Youtuber yt2 = new Youtuber(2, "Supercars");
        youtubers.add(yt2);
        yt2.setCategory(7);
        yt2.addVideo(v4);
        yt2.addVideo(v5);

        Viewer a = new Viewer(1, "Phan Van A");
        String[] interests1 = new String[]{"TECH", "FUNNY", "MUSIC"};
        a.setInterest(interests1);

        Viewer b = new Viewer(2, "Nguyen Van B");
        String[] interests2 = new String[]{"NEWS", "CAR", "TECH"};
        b.setInterest(interests2);

        youtubers.forEach(youtuber -> {
            for (String s : interests1) {
                if (youtuber.getCategory().equals(s))
                    a.subscribe(youtuber);
            }
            for (String s : interests2) {
                if (youtuber.getCategory().equals(s))
                    b.subscribe(youtuber);
            }
        });

        b.unsubscribe(yt);
        yt.deleteVideo(v2);

        yt.exportVideoList("listVideo.txt");
        b.exportYoutuberList("listYoutuber.txt");
        yt.exportViewerList("listViewer.txt");

        // Cau 2
        youtubers.forEach(Youtuber::onNotification);

        List<Video> videoListOfYt = yt.getVideoList();
        videoListOfYt.forEach(video -> {
            Thread t = new Thread(() -> {
                try {
                    b.watchVideo(video);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            try {
                t.start();
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
