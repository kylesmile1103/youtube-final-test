package com.finaltest.youtube;

import java.util.List;

public interface IViewer {
    void addViewer(Viewer Viewer);
    Viewer searchViewer(double id);
    void deleteViewer(Viewer Viewer);
    void exportViewerList(String path);
}
