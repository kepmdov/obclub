package com.修仙界.世界.地点;

import com.修仙界.种族.人族;
import com.修仙界.种族.种族;

import java.util.ArrayList;

public class 河流 implements 机缘{

    @Override
    public void 机缘触发(ArrayList<种族> 触发人物) {
        if (触发人物.size()<5){
            for (种族 种族:触发人物){
                if (种族.getClass()== 人族.class){

                }
            }
        }
    }
}
