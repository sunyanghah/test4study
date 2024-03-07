package test.study.java.mianshiti2023;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sunyang
 * @date 2023-11-01
 * @desc
 */
public class Test1101 {

    public static void main(String[] args) {

    }

    public interface MusicPlayer {

        void play(String fileName);

        void stop(String fileName);

    }


    public static class OldMusicPlayer implements MusicPlayer {

        @Override
        public void play(String fileName) {
            System.out.println("start play mp3 music");
        }

        @Override
        public void stop(String fileName) {
            System.out.println("stop play mp3 music");
        }
    }

    public static class MusicPlayerAdapter implements MusicPlayer {

        @Override
        public void play(String fileName) {
            switch (fileName){
                case "mp3":
            }
        }

        @Override
        public void stop(String fileName) {

        }
    }


    public static class WmaMusicPlayer implements MusicPlayer {

        @Override
        public void play(String fileName) {
            System.out.println("start play wma music");
        }

        @Override
        public void stop(String fileName) {
            System.out.println("stop play wma music");
        }
    }

    public static class WavMusicPlayer implements MusicPlayer {

        @Override
        public void play(String fileName) {
            System.out.println("start play wav music");
        }

        @Override
        public void stop(String fileName) {
            System.out.println("stop play wav music");
        }
    }

}
