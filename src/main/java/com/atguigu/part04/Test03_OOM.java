package com.atguigu.part04;

import com.atguigu.util.SleepUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author lucky845
 * @date 2022年03月26日 9:52
 */
public class Test03_OOM {

    /*
        -Xms600m -Xmx600m
        开发环境中建议把最大堆内存和初始堆内存设置为一致  防止GC
     */
    public static void main(String[] args) {
        List<Picture> pictureList = new ArrayList<>();
        while (true) {
            SleepUtils.sleep(30);
            pictureList.add(new Picture(new Random().nextInt(1024 * 1024)));
        }
    }

}

class Picture {

    private byte[] pixels;

    public Picture(int length) {
        this.pixels = new byte[length];
    }

}
