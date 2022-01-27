package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name, artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    private Song findSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            Song tempSong = songs.get(i);
            if (tempSong.getTitle().equals(title)) {
                return tempSong;
            }
        }
        return null;
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            Song tempSongs = new Song(title, duration);
            songs.add(tempSongs);
            return true;
        } else {
            return false;
        }

    }

    public boolean addToPlayList(String title, LinkedList<Song> songs) {
        Song tempSongs = findSong(title);
        if (tempSongs == null) {
            return false;
        } else {
            return songs.add(tempSongs);
        }
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> songs1) {
        if (trackNumber <= 0 || trackNumber> songs.size()) {
            return false;
        } else {
            Song tempSongs = songs.get(trackNumber - 1);
            songs1.add(tempSongs);
            return true;
        }
    }
}
