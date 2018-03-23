package Entities;

import java.util.Objects;

public class ChildVideo {

    private int childId;
    private int videoId;

    
    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }


    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildVideo that = (ChildVideo) o;
        return childId == that.childId &&
                videoId == that.videoId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(childId, videoId);
    }
}
