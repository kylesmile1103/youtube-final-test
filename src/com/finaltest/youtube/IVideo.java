package com.finaltest.youtube;

import java.util.List;

public interface IVideo {
    void addVideo(Video video);
    Video searchVideo(double id);
    void updateVideo(Video video, String title);
    void deleteVideo(Video video);
    void exportVideoList(String path);
}
