

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

//²¥·ÅÉùÒôÀà
public class AudioTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AePlayWave ae=new AePlayWave("e://tank.wav");
		ae.start();
	}

}

class AePlayWave extends Thread{
	private String filename;
	public AePlayWave(String wavfile){
		filename=wavfile;
	}
	public void run(){
		File soundFile=new File(filename);
		AudioInputStream audioInputStream=null;
		try{
			audioInputStream=AudioSystem.getAudioInputStream(soundFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		AudioFormat format=audioInputStream.getFormat();
		SourceDataLine auline=null;
		DataLine.Info info=new DataLine.Info(SourceDataLine.class, format);
		try {
			auline=(SourceDataLine)AudioSystem.getLine(info);
			auline.open(format);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		auline.start();
		int nBytesRead=0;
		byte[] abData=new byte[1024];
		try {
			while(nBytesRead!=-1){
			nBytesRead=audioInputStream.read(abData, 0, abData.length);
			if(nBytesRead>=0)
				auline.write(abData, 0,nBytesRead);
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				auline.drain();
				auline.close();
			}
			
		
	}
}