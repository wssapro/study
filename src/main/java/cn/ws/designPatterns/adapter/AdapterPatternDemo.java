package cn.ws.designPatterns.adapter;

/**
 * @description: ${description}
 * @Author wangshun
 * @create: 2019-07-24 17:17
 */
interface MediaPlayer {
    void play(String audioType, String fileName);
}
class AudioPlayer implements MediaPlayer{
    MediaPlayerAdapter mediaPlayerAdapter;
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp4")){
            mediaPlayerAdapter = new MediaPlayerAdapter();
            mediaPlayerAdapter.play(audioType,fileName);
        }else{
            System.out.println("use AudioPlayer Playing "+audioType+" name is "+fileName);
        }
    }
}
class MediaPlayerAdapter implements MediaPlayer{
    AdvancedMediaPlayer advancedMediaPlayer;
    @Override
    public void play(String audioType, String fileName) {
        advancedMediaPlayer = new Mp4Player();
        advancedMediaPlayer.playMp4(audioType,fileName);
    }
}
interface AdvancedMediaPlayer{
    void playMp4(String audioType, String fileName);
}
class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void playMp4(String audioType, String fileName) {
        System.out.println("use MP4Player Playing "+audioType+" name is "+fileName);
    }
}
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}