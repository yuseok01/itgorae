package A형대비문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 특이한자석2 {
    static int[] m1, m2, m3, m4;
    static int m1i, m2i, m3i, m4i;
    static int k, score;
    static int[] rotm, rotd; //돌릴 자석, 방향
    static boolean[] isConnect;

    
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            k =  Integer.parseInt(br.readLine());
            score = 0;
            m1i=0;
            m2i=0;
            m3i=0;
            m4i=0;
            m1 = new int[8];
            m2 = new int[8];
            m3 = new int[8];
            m4 = new int[8];
            rotm = new int[k];
            rotd = new int[k];
            isConnect = new boolean[3];
            
            String st1 = br.readLine();
            String st2 = br.readLine();
            String st3 = br.readLine();
            String st4 = br.readLine();
            

            for(int i=0; i<8; i++) {
                m1[i] = st1.charAt(i*2)-'0';
                m2[i] = st2.charAt(i*2)-'0';
                m3[i] = st3.charAt(i*2)-'0';
                m4[i] = st4.charAt(i*2)-'0';
            }
            for(int i=0; i<k; i++) {
                String[] str = br.readLine().split(" ");
                rotm[i] = Integer.parseInt(str[0]);
                rotd[i] = Integer.parseInt(str[1]);
            }
            rotMag(0);

            int score = (m4[m4i&7]<<3)|(m3[m3i&7]<<2)|(m2[m2i&7]<<1)|(m1[m1i&7]<<0);
            
            System.out.println("#"+tc+" "+score);
        }
        
    }
    
    
    static void isConnect() {
        isConnect[0] = (m1[(m1i+2)&7]^m2[(m2i+6)&7])==1;
        isConnect[1] = (m2[(m2i+2)&7]^m3[(m3i+6)&7])==1;
        isConnect[2] = (m3[(m3i+2)&7]^m4[(m4i+6)&7])==1;
    }
    
    static void rotMag(int idx) {
        if(idx==k) return;
        isConnect = new boolean[3];
        isConnect();
        
        int num = rotm[idx];
        int dir = rotd[idx];
        switch(num) {
        case 1:
            m1i-=dir;
            if(isConnect[0]) {
                m2i+=dir;
                if(isConnect[1]) {
                    m3i-=dir;
                    if(isConnect[2])
                        m4i+=dir;
                }
            }
            break;
        case 2:
            m2i-=dir;
            if(isConnect[0]) {
                m1i+=dir;
            }
            if(isConnect[1]) {
                m3i+=dir;
                if(isConnect[2]) {
                    m4i-=dir;
                }
            }
            break;
        case 3:
            m3i-=dir;
            if(isConnect[2]) {
                m4i+=dir;
            }
            if(isConnect[1]) {
                m2i+=dir;
                if(isConnect[0]) {
                    m1i-=dir;
                }
            }
            break;
        case 4:
            m4i-=dir;
            if(isConnect[2]) {
                m3i+=dir;
                if(isConnect[1]) {
                    m2i-=dir;
                    if(isConnect[0])
                        m1i+=dir;
                }
            }
            break;
        }
        rotMag(idx+1);
    }

}